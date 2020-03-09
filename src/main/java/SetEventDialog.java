import java.io.IOException;
import javax.swing.JOptionPane;
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
 * @author leeja
 */
public class SetEventDialog extends javax.swing.JDialog {

    /**
     * Creates new form SetEventDialog
     */
    public SetEventDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField_setEvent = new javax.swing.JTextField();
        button_setEvent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        button_setEvent.setText("Set Event");
        button_setEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_setEventActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_setEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textField_setEvent))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textField_setEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_setEvent)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_setEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_setEventActionPerformed
        String eventKey = textField_setEvent.getText();
        
        JSONObject jsonObj = getJSONObject("/event/" + eventKey);
        if (jsonObj == null) {
            return;
        }
        
        ((MainWindow) getParent()).setEventKey(eventKey);
        
        dispose();
    }//GEN-LAST:event_button_setEventActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_setEvent;
    private javax.swing.JTextField textField_setEvent;
    // End of variables declaration//GEN-END:variables

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
}
