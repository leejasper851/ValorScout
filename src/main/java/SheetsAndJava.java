
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.java6.auth.oauth2.VerificationCodeReceiver;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.*;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetRequest;
import com.google.api.services.sheets.v4.model.DeleteDimensionRequest;
import com.google.api.services.sheets.v4.model.DimensionRange;
import com.google.api.services.sheets.v4.model.Request;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.*;
import java.util.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel Diaz
 */



public class SheetsAndJava {
    
    private static Sheets sheetsService;
    private static String APPLICATION_NAME = "Google Sheets Example";
    private static String SPREADSHEET_ID = "11xpw6QtdNyZ2zBMGsHt2EqxB2gYrnjjuqROvooInyUw";
    
    private static Credential authorize() throws IOException, GeneralSecurityException {
        InputStream in = SheetsAndJava.class.getResourceAsStream("credentials.json");
        GoogleClientSecrets clientSecrets;
        clientSecrets = GoogleClientSecrets.load(JacksonFactory.getDefaultInstance(), new InputStreamReader(in));
        
        List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);
        
        GoogleAuthorizationCodeFlow flow;
        flow = new GoogleAuthorizationCodeFlow.Builder(GoogleNetHttpTransport.newTrustedTransport(), 
            JacksonFactory.getDefaultInstance(), clientSecrets, scopes)
            .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
            .setAccessType("offline")
            .build();
        
        Credential credential = new AuthorizationCodeInstalledApp(
            flow, new LocalServerReceiver())
                .authorize("user");
        
        return credential;
    }
    
    public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        Credential credential = authorize();
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(),
        JacksonFactory.getDefaultInstance(), credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
    
   public static void stuff() throws IOException, GeneralSecurityException {
        sheetsService = getSheetsService();
        //READ FROM SPREEDSHEET
        String range = "Sheet1!A2:F10";
        
        ValueRange response = sheetsService.spreadsheets().values()
            .get(SPREADSHEET_ID, range)
            .execute();
        
        List<List<Object>> values = response.getValues();
        
        if(values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            for(List row : values) {
                System.out.printf( "%s %s from %s\n", row.get(5), row.get(4), row.get(1));
            }
        }

////WIRTE TO SHEET
//        ValueRange appendBody;
//        appendBody = new ValueRange().setValues(Arrays.asList(Arrays.asList((Object)"poop", "butt", "fart", "shithead", "code!")));
//        
//        AppendValuesResponse appendResult = sheetsService.spreadsheets().values()
//                .append(SPREADSHEET_ID, "Sheet1", appendBody)
//                .setValueInputOption("USER_ENTERED")
//                .setInsertDataOption("INSERT_ROWS")
//                .setIncludeValuesInResponse(true)
//                .execute();

//UPDATE SHEET
//ValueRange body;
//        body = new ValueRange().setValues(Arrays.asList(Arrays.asList((Object)"updated")));
//        
//        UpdateValuesResponse result = sheetsService.spreadsheets().values()
//                .update(SPREADSHEET_ID, "C543", body)
//                .setValueInputOption("RAW")
//                .execute();

//DELEtE
//    DeleteDimensionRequest deleteRequest = new DeleteDimensionRequest()
//            .setRange(
//                new DimensionRange()
//                .setSheetId(0)
//                .setDimension("ROWS")
//                .setStartIndex(542)
//            );
//    
//    List<Request> requests = new ArrayList<>();
//    requests.add(new Request().setDeleteDimension(deleteRequest));
//    
//    BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
//    sheetsService.spreadsheets().batchUpdate(SPREADSHEET_ID, body).execute();
   }

    public static void writeToSheet(TreeMap<Integer, Team> teams) throws IOException,  GeneralSecurityException {

        List<List<Object>> teamMatchHistory = new ArrayList<>();
        for(Integer teamNumber : teams.keySet()) {
            Team t = teams.get(teamNumber);
            TreeMap<Integer, MatchStat> teamStats = t.getTeamStats();
            if(!teamStats.isEmpty()){
                for(Integer matchNumber:teamStats.keySet()) {
                    MatchStat m = teamStats.get(matchNumber);
                    if(m.isPlayed()) {
                        List<Object> matchInfo = new ArrayList<>();
                        matchInfo.add(matchNumber);
                        matchInfo.add(teamNumber);
                        matchInfo.add(t.getName());
                        matchInfo.add(m.isCrossLine());
                        matchInfo.add(m.getAutoShieldBottom());
                        matchInfo.add(m.getAutoShieldTop());
                        matchInfo.add(m.getAutoShieldInner());
                        matchInfo.add(m.getTeleShieldBottom());
                        matchInfo.add(m.getTeleShieldTop());
                        matchInfo.add(m.getTeleShieldInner());
                        matchInfo.add(m.isRotControl());
                        matchInfo.add(m.isPosControl());
                        matchInfo.add(m.isPark());
                        matchInfo.add(m.isHang());
                        matchInfo.add(m.isLevel());
                        matchInfo.add(m.getHost());
                        matchInfo.add(m.getDefense());
                        teamMatchHistory.add(matchInfo);
                        //System.out.println(matchInfo.toString());
                        //matchInfo = new ArrayList<>();
                    }
                }
            }
        }
        sheetsService = getSheetsService();
        
        ValueRange appendBody;
        appendBody = new ValueRange().setValues(teamMatchHistory);
        
        AppendValuesResponse appendResult = sheetsService.spreadsheets().values()
                .append(SPREADSHEET_ID, "Sheet1", appendBody)
                .setValueInputOption("USER_ENTERED")
                .setInsertDataOption("INSERT_ROWS")
                .setIncludeValuesInResponse(true)
                .execute();
        
    }
    
    public static TreeMap<Integer, Team> readFromSheet() throws IOException,  GeneralSecurityException {
        
        sheetsService = getSheetsService();
        String range = "Sheet1!A2:Q10";
        
        ValueRange response = sheetsService.spreadsheets().values()
            .get(SPREADSHEET_ID, range)
            .execute();
        
        List<List<Object>> values = response.getValues();
        
        TreeMap<Integer, Team> teams = new TreeMap<>();
        if(values == null || values.isEmpty()) {
            //System.out.println("No data found.");
        } else {
            for(List row : values) {
                if(!teams.containsKey(Integer.parseInt((String)row.get(1)))) {
                    teams.put(Integer.parseInt((String)row.get(1)), new Team(Integer.parseInt((String)row.get(1)), (String)row.get(2)));
                }
                Team t = teams.get(Integer.parseInt((String)row.get(1)));
                t.addTeamStat(Integer.parseInt((String)row.get(0)), new MatchStat(
                    Boolean.parseBoolean((String)row.get(3)), // CrossLine
                    Integer.parseInt((String)row.get(4)), // AutoLow
                    Integer.parseInt((String)row.get(5)), // AutoTop
                    Integer.parseInt((String)row.get(6)), // AutoInner
                    Integer.parseInt((String)row.get(7)), // TeleLow
                    Integer.parseInt((String)row.get(8)), // TeleTop
                    Integer.parseInt((String)row.get(9)), // TeleInner
                    Boolean.parseBoolean((String)row.get(10)), // rotControl
                    Boolean.parseBoolean((String)row.get(11)), // posContol
                    Boolean.parseBoolean((String)row.get(12)), // park
                    Boolean.parseBoolean((String)row.get(13)), // hang
                    Boolean.parseBoolean((String)row.get(14)), // level
                    Integer.parseInt((String)row.get(15)), // host
                    Integer.parseInt((String)row.get(16)), // defense
                    true)); // played
            }
        }
        return teams;
    }

}


