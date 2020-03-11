
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.GeneralSecurityException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import okhttp3.*;
import org.json.simple.*;
import org.json.simple.parser.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lee_934859
 */
public class MainWindow extends javax.swing.JFrame {
    private TreeMap<Integer, Team> teams;
    private TreeSet<Integer> rankedTeams;
    private TreeMap<Integer, QualsMatch> matches;
    private String eventKey;
    
    private File currentFile;
    private EventModel event;
    
    
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        
        setTitle("ValorScout");
        
        teams = new TreeMap<>();
        rankedTeams = new TreeSet<>();
        matches = new TreeMap<>();
        
        currentFile = null;
        event = new EventModel();
        
        comboBox_displayStat.removeAllItems();
        comboBox_displayStat.addItem("Average Score");
        comboBox_displayStat.addItem("Average Defense");
        
        eventKey = "2019txaus";
        loadEvent();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        panel_teams = new javax.swing.JPanel();
        scrollPane_teams = new javax.swing.JScrollPane();
        table_teams = new javax.swing.JTable();
        comboBox_displayStat = new javax.swing.JComboBox();
        panel_matches = new javax.swing.JPanel();
        scrollPane_matches = new javax.swing.JScrollPane();
        table_matches = new javax.swing.JTable();
        panel_scouting = new javax.swing.JPanel();
        scrollPane_scouting = new javax.swing.JScrollPane();
        table_scouting = new javax.swing.JTable();
        panel_simulations = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        menu_file = new javax.swing.JMenu();
        menuItem_setEvent = new javax.swing.JMenuItem();
        jMenuItem_Upload = new javax.swing.JMenuItem();
        jMenuItem_Download = new javax.swing.JMenuItem();
        jMenuItem_SaveAs = new javax.swing.JMenuItem();
        jMenuItem_Save = new javax.swing.JMenuItem();
        jMenuItem_Open = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table_teams.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Team", "Name", "RP", "OPR", "DPR", "Matches", "Display Stat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPane_teams.setViewportView(table_teams);

        comboBox_displayStat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBox_displayStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_displayStatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_teamsLayout = new javax.swing.GroupLayout(panel_teams);
        panel_teams.setLayout(panel_teamsLayout);
        panel_teamsLayout.setHorizontalGroup(
            panel_teamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_teamsLayout.createSequentialGroup()
                .addContainerGap(736, Short.MAX_VALUE)
                .addComponent(comboBox_displayStat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(scrollPane_teams)
        );
        panel_teamsLayout.setVerticalGroup(
            panel_teamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_teamsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBox_displayStat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane_teams, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Teams", panel_teams);

        table_matches.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Match", "R1", "R2", "R3", "B1", "B2", "B3", "R Score", "B Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPane_matches.setViewportView(table_matches);

        javax.swing.GroupLayout panel_matchesLayout = new javax.swing.GroupLayout(panel_matches);
        panel_matches.setLayout(panel_matchesLayout);
        panel_matchesLayout.setHorizontalGroup(
            panel_matchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane_matches, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
        );
        panel_matchesLayout.setVerticalGroup(
            panel_matchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane_matches, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Matches", panel_matches);

        table_scouting.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Match", "R1", "R2", "R3", "B1", "B2", "B3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_scouting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_scoutingMouseClicked(evt);
            }
        });
        scrollPane_scouting.setViewportView(table_scouting);

        javax.swing.GroupLayout panel_scoutingLayout = new javax.swing.GroupLayout(panel_scouting);
        panel_scouting.setLayout(panel_scoutingLayout);
        panel_scoutingLayout.setHorizontalGroup(
            panel_scoutingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane_scouting, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
        );
        panel_scoutingLayout.setVerticalGroup(
            panel_scoutingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane_scouting, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Scouting", panel_scouting);

        javax.swing.GroupLayout panel_simulationsLayout = new javax.swing.GroupLayout(panel_simulations);
        panel_simulations.setLayout(panel_simulationsLayout);
        panel_simulationsLayout.setHorizontalGroup(
            panel_simulationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        panel_simulationsLayout.setVerticalGroup(
            panel_simulationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Simulations", panel_simulations);

        menu_file.setText("File");

        menuItem_setEvent.setText("Set Event");
        menuItem_setEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_setEventActionPerformed(evt);
            }
        });
        menu_file.add(menuItem_setEvent);

        jMenuItem_Upload.setText("Upload to Sheets");
        jMenuItem_Upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_UploadActionPerformed(evt);
            }
        });
        menu_file.add(jMenuItem_Upload);

        jMenuItem_Download.setText("Download from Sheets");
        jMenuItem_Download.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_DownloadActionPerformed(evt);
            }
        });
        menu_file.add(jMenuItem_Download);

        jMenuItem_SaveAs.setText("Save As");
        jMenuItem_SaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_SaveAsActionPerformed(evt);
            }
        });
        menu_file.add(jMenuItem_SaveAs);

        jMenuItem_Save.setText("Save");
        jMenuItem_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_SaveActionPerformed(evt);
            }
        });
        menu_file.add(jMenuItem_Save);

        jMenuItem_Open.setText("Open");
        jMenuItem_Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_OpenActionPerformed(evt);
            }
        });
        menu_file.add(jMenuItem_Open);

        menuBar.add(menu_file);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItem_setEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_setEventActionPerformed
        String origKey = String.valueOf(eventKey);
        
        SetEventDialog dialog = new SetEventDialog(this, true);
        dialog.setTitle("Set Event");
        dialog.setVisible(true);
        
        if (eventKey != origKey) {
            loadEvent();
        }
    }//GEN-LAST:event_menuItem_setEventActionPerformed

    private void table_scoutingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_scoutingMouseClicked
        if (evt.getClickCount() == 2) {
            int clickRow = table_scouting.getSelectedRow();
            int clickCol = table_scouting.getSelectedColumn();
            if (clickCol == 0) {
                return;
            }
            
            int team = (int) table_scouting.getValueAt(clickRow, clickCol);
            int match = clickRow+1;
            
            MatchStat matchStat = teams.get(team).getTeamStats().get(match);
            
            ScoutingWindow scoutingWindow = new ScoutingWindow(this, matchStat, match, team);
            scoutingWindow.setTitle("Q-" + match + ": " + team);
            scoutingWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            scoutingWindow.setVisible(true);
        }
    }//GEN-LAST:event_table_scoutingMouseClicked

//<<<<<<< HEAD
    private void jMenuItem_UploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_UploadActionPerformed
        try {
            SheetsAndJava.writeToSheet(teams);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem_UploadActionPerformed

    private void jMenuItem_DownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_DownloadActionPerformed
        try {
            
            TreeMap<Integer, Team> teamsFromSheets = SheetsAndJava.readFromSheet();
            for(Integer teamNumber: teamsFromSheets.keySet()) {
                teams.put(teamNumber, teamsFromSheets.get(teamNumber));
            }
            updateTeamsTable();
            
            //updates matches based on what teams have played
            for(Integer matchNumber : matches.keySet()) {
                Match m = matches.get(matchNumber);
                
                m.updateMatchScores(
                        teams.get(m.getRed1()).getTeamStats().containsKey(matchNumber) ? teams.get(m.getRed1()).getTeamStats().get(matchNumber).getTotalPoints() : 0,
                        teams.get(m.getRed2()).getTeamStats().containsKey(matchNumber) ? teams.get(m.getRed2()).getTeamStats().get(matchNumber).getTotalPoints() : 0,
                        teams.get(m.getRed3()).getTeamStats().containsKey(matchNumber) ? teams.get(m.getRed3()).getTeamStats().get(matchNumber).getTotalPoints() : 0,
                        teams.get(m.getBlue1()).getTeamStats().containsKey(matchNumber) ? teams.get(m.getBlue1()).getTeamStats().get(matchNumber).getTotalPoints() : 0,
                        teams.get(m.getBlue2()).getTeamStats().containsKey(matchNumber) ? teams.get(m.getBlue2()).getTeamStats().get(matchNumber).getTotalPoints() : 0,
                        teams.get(m.getBlue3()).getTeamStats().containsKey(matchNumber) ? teams.get(m.getBlue3()).getTeamStats().get(matchNumber).getTotalPoints() : 0
                );
            }
            
            updateMatchesTable();
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem_DownloadActionPerformed
//=======
    private void comboBox_displayStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_displayStatActionPerformed
        updateTeamsTable();
    }//GEN-LAST:event_comboBox_displayStatActionPerformed

    private void jMenuItem_SaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_SaveAsActionPerformed
        // TODO add your handling code here:
         JFileChooser jfc = new JFileChooser();

        jfc.setCurrentDirectory(new File(System.getProperty("user.dir")));

        if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            writeModelToFile(jfc.getSelectedFile()); 
        }
    }//GEN-LAST:event_jMenuItem_SaveAsActionPerformed

    private void jMenuItem_OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_OpenActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            JFileChooser jfc = new JFileChooser();
            jfc.setCurrentDirectory(new File(System.getProperty("user.dir")));
            
            if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                FileInputStream fis  = new FileInputStream(jfc.getSelectedFile());
                ObjectInputStream ois = new ObjectInputStream(fis);
                
                event = (EventModel)ois.readObject();
                 
                eventKey = event.getEventKey();
                teams = event.getTeams();
                matches = event.getMatches();
                
                System.out.println(eventKey);
                System.out.println(teams.size());
                System.out.println(matches.size());
                
                updateTeamsTable();
                updateMatchesTable();
                updateScoutingTable();
            }
   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR: File not found", "ok beast 2", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR: File not found", "ok beast 2", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR: File not found", "ok beast 2", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem_OpenActionPerformed

    private void jMenuItem_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_SaveActionPerformed
        // TODO add your handling code here:
         if (currentFile == null) {
            jMenuItem_SaveAsActionPerformed(evt);
        }
        else{
            writeModelToFile(currentFile);   
            //jMenuItem_save.setEnabled(false);
        }
    }//GEN-LAST:event_jMenuItem_SaveActionPerformed
//>>>>>>> b7eb578fdef16200175103bb0eef3dce664255ee

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboBox_displayStat;
    private javax.swing.JMenuItem jMenuItem_Download;
    private javax.swing.JMenuItem jMenuItem_Open;
    private javax.swing.JMenuItem jMenuItem_Save;
    private javax.swing.JMenuItem jMenuItem_SaveAs;
    private javax.swing.JMenuItem jMenuItem_Upload;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItem_setEvent;
    private javax.swing.JMenu menu_file;
    private javax.swing.JPanel panel_matches;
    private javax.swing.JPanel panel_scouting;
    private javax.swing.JPanel panel_simulations;
    private javax.swing.JPanel panel_teams;
    private javax.swing.JScrollPane scrollPane_matches;
    private javax.swing.JScrollPane scrollPane_scouting;
    private javax.swing.JScrollPane scrollPane_teams;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable table_matches;
    private javax.swing.JTable table_scouting;
    private javax.swing.JTable table_teams;
    // End of variables declaration//GEN-END:variables
    
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
    
    private JSONArray getJSONArray(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
            .header("X-TBA-Auth-Key", "j62Ln03NS6nIrke6c9YiRvRvDmNLSys92adlRZfoeEm1dcCPZ8OMRq2xDd6KtJDO")
            .url("https://www.thebluealliance.com/api/v3" + url)
            .build();
        
        String jsonStr = "";
        try {
            try (Response response = client.newCall(request).execute()) {
                jsonStr = response.body().string();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "ERROR: Cannot access Blue Alliance!", "Blue Alliance Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        Object jsonRaw;
        try {
            jsonRaw = new JSONParser().parse(jsonStr);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "ERROR: Cannot parse Blue Alliance data!", "Blue Alliance Data Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        if (jsonRaw instanceof JSONObject) {
            JOptionPane.showMessageDialog(this, "ERROR: Event key not found!", "Event Key Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        return (JSONArray) jsonRaw;
    }
    
    private JSONObject getJSONObject(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
            .header("X-TBA-Auth-Key", "j62Ln03NS6nIrke6c9YiRvRvDmNLSys92adlRZfoeEm1dcCPZ8OMRq2xDd6KtJDO")
            .url("https://www.thebluealliance.com/api/v3" + url)
            .build();

        String jsonStr = "";
        try {
            try (Response response = client.newCall(request).execute()) {
                jsonStr = response.body().string();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "ERROR: Cannot access Blue Alliance!", "Blue Alliance Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Object jsonRaw;
        try {
            jsonRaw = new JSONParser().parse(jsonStr);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "ERROR: Cannot parse Blue Alliance data!", "Blue Alliance Data Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        JSONObject jsonObj = (JSONObject) jsonRaw;
        if (jsonObj.containsKey("Errors")) {
            JOptionPane.showMessageDialog(this, "ERROR: Event key not found!", "Event Key Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        return jsonObj;
    }
    
    private void loadEvent() {
        boolean loadTeamsRes = loadEventTeams();
        if (!loadTeamsRes) {
            return;
        }
        loadEventMatches();
    }
    
    private boolean loadEventTeams() {
        JSONArray jsonArr = getJSONArray("/event/" + eventKey + "/teams/simple");
        if (jsonArr == null) {
            return false;
        }
        
        teams.clear();
        for (Object obj : jsonArr) {
            JSONObject jsonObj = (JSONObject) obj;
            
            int teamNum = (int) (long) jsonObj.get("team_number");
            String teamName = (String) jsonObj.get("nickname");
            
            teams.put(teamNum, new Team(teamNum, teamName));
        }
        
        updateTeamsTable();
        
        return true;
    }
    
    private void loadEventMatches() {
        JSONArray jsonArr = getJSONArray("/event/" + eventKey + "/matches/simple");
        if (jsonArr == null) {
            return;
        }
        
        matches.clear();
        for (Object obj : jsonArr) {
            JSONObject jsonObj = (JSONObject) obj;
            
            if (!((String) jsonObj.get("key")).contains("qm")) {
                continue;
            }
            
            int matchNum = (int) (long) jsonObj.get("match_number");
            JSONObject alliances = (JSONObject) jsonObj.get("alliances");
            JSONObject redAlliance = (JSONObject) alliances.get("red");
            JSONArray redTeams = (JSONArray) redAlliance.get("team_keys");
            int red1 = Integer.parseInt(((String) redTeams.get(0)).substring(3));
            int red2 = Integer.parseInt(((String) redTeams.get(1)).substring(3));
            int red3 = Integer.parseInt(((String) redTeams.get(2)).substring(3));
            int redScore = (int) (long) redAlliance.get("score");
            JSONObject blueAlliance = (JSONObject) alliances.get("blue");
            JSONArray blueTeams = (JSONArray) blueAlliance.get("team_keys");
            int blue1 = Integer.parseInt(((String) blueTeams.get(0)).substring(3));
            int blue2 = Integer.parseInt(((String) blueTeams.get(1)).substring(3));
            int blue3 = Integer.parseInt(((String) blueTeams.get(2)).substring(3));
            int blueScore = (int) (long) blueAlliance.get("score");
            
            matches.put(matchNum, new QualsMatch(matchNum, red1, red2, red3, blue1, blue2, blue3, redScore, blueScore));
            
            teams.get(red1).addTeamStat(matchNum, new MatchStat());
            teams.get(red2).addTeamStat(matchNum, new MatchStat());
            teams.get(red3).addTeamStat(matchNum, new MatchStat());
            teams.get(blue1).addTeamStat(matchNum, new MatchStat());
            teams.get(blue2).addTeamStat(matchNum, new MatchStat());
            teams.get(blue3).addTeamStat(matchNum, new MatchStat());
        }
        
        updateMatchesTable();
        updateScoutingTable();
        updateTeamsTable();
    }
    
    private void updateTeamsTable() {
        DefaultTableModel model = (DefaultTableModel) table_teams.getModel();
        model.setRowCount(0);
        
        for (Team team : teams.values()) {
            Object[] teamData = new Object[7];
            teamData[0] = team.getNumber();
            teamData[1] = team.getName();
            teamData[2] = team.getRp();
            teamData[3] = team.getOpr();
            teamData[4] = team.getDpr();
            String teamMatches = team.getTeamStats().keySet().toString();
            teamMatches = teamMatches.substring(1, teamMatches.length()-1);
            teamData[5] = teamMatches;
            if (comboBox_displayStat.getSelectedItem().equals("Average Score")) {
                teamData[6] = team.getAverageScore();
            } else {
                teamData[6] = team.getAverageDefense();
            }
            
            model.addRow(teamData);
        }
    }
    
    private void updateMatchesTable() {
        DefaultTableModel model = (DefaultTableModel) table_matches.getModel();
        model.setRowCount(0);
        
        for (QualsMatch match : matches.values()) {
            Object[] matchData = new Object[9];
            matchData[0] = match.toString();
            matchData[1] = match.getRed1();
            matchData[2] = match.getRed2();
            matchData[3] = match.getRed3();
            matchData[4] = match.getBlue1();
            matchData[5] = match.getBlue2();
            matchData[6] = match.getBlue3();
            matchData[7] = (match.getRealRedScore() == 0) ? match.getScoutRedScore() : match.getRealRedScore();
            matchData[8] = (match.getRealBlueScore() == 0) ? match.getScoutBlueScore() : match.getRealBlueScore();
            
            model.addRow(matchData);
        }
    }
    
    private void updateScoutingTable() {
        DefaultTableModel model = (DefaultTableModel) table_scouting.getModel();
        model.setRowCount(0);
        
        for (QualsMatch match : matches.values()) {
            Object[] matchData = new Object[9];
            matchData[0] = match.toString();
            matchData[1] = match.getRed1();
            matchData[2] = match.getRed2();
            matchData[3] = match.getRed3();
            matchData[4] = match.getBlue1();
            matchData[5] = match.getBlue2();
            matchData[6] = match.getBlue3();
            
            model.addRow(matchData);
        }
    }
    
    public void updateScore(int match, int team) {
        matches.get(match).updateScore(team, teams.get(team).getTeamStats().get(match).getTotalPoints());
        
        updateMatchesTable();
        updateTeamsTable();
    }

    private void writeModelToFile(File file) {
        try {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                event.setEventKey(eventKey);
                event.setTeams(teams);
                event.setMatches(matches);
                
                oos.writeObject(event);
                currentFile = file;
                oos.close();
                //menuItem_save.se();
            

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR: File not found", "ok beast 2", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR: No permission", "ok beast 2", JOptionPane.ERROR_MESSAGE);
        }
    }
}
