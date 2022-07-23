/*
 * Created by JFormDesigner on Sat Jul 23 04:03:43 TRT 2022
 */

package views;

import models.NoteImpl;
import props.Notes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class MainApp extends JFrame {
    NoteImpl notesImpl = new NoteImpl();
    int row = -1;
    int nid = 0;
    int column = 0;
    public static void main(String[] args) {
        new MainApp().setVisible(true);
    }
    public MainApp() {
        initComponents();
    }

    private Notes fncDataValidate(){
        String title = txtTitle.getText().trim();
        String detail = txtDetails.getText().trim();
        String date = utils.Util.dateTimeNow();

        if (title.equals("")){
            lblError.setText("Title cannot be empty!");
            txtTitle.requestFocus();
        }else if (detail.equals("")){
            lblError.setText("Details cannot be empty!");
            txtDetails.requestFocus();
        }else{
            lblError.setText("");
            Notes notes= new Notes(title,detail,date);
            return notes;
        }
        return null;
    }

    void rowSelect(){
        row = tblNotes.getSelectedRow();
        String title = (String) tblNotes.getValueAt(row, 1);
        String details = (String) tblNotes.getValueAt(row, 2);

        txtTitle.setText(title);
        txtDetails.setText(details);
    }

    private void btnSaveMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void btnUpdateMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void btnDeleteMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void tblNotesKeyReleased(KeyEvent e) {
        // TODO add your code here
        rowSelect();
    }

    private void tblNotesMouseClicked(MouseEvent e) {
        // TODO add your code here
        rowSelect();
    }

    private void btnSave(ActionEvent e) {
        // TODO add your code here
        Notes notes = fncDataValidate();
        if (notes != null ) {
            int status = notesImpl.Insert(notes);
            if (status > 0) {
                tblNotes.setModel(notesImpl.notesTableModel());
                txtTitle.setText("");
                txtDetails.setText("");
            }else {
                lblError.setText("Insert Error!");
            }
        }
    }

    private void btnUpdate(ActionEvent e) {
        // TODO add your code here
        Notes notes = fncDataValidate();
        if(row != -1 ) {
            row = tblNotes.getSelectedRow();
            nid = Integer.valueOf(tblNotes.getModel().getValueAt(row,column).toString());
            int answer=JOptionPane.showConfirmDialog(this,"Are you sure?","Update Window",JOptionPane.YES_OPTION);
            if (answer == 0) {
                notesImpl.Update(notes,nid);
                tblNotes.setModel(notesImpl.notesTableModel());
                txtTitle.setText("");
                txtDetails.setText("");
                row = -1;
            }
        }else{
            JOptionPane.showMessageDialog(this,"Please make a choose from the list.");
        }

    }

    private void btnDelete(ActionEvent e) {
        // TODO add your code here
        if (row != -1) {
            int answer=JOptionPane.showConfirmDialog(this,"Are you sure?","Delete Window",JOptionPane.YES_OPTION);
            row = tblNotes.getSelectedRow();
            nid = Integer.valueOf(tblNotes.getModel().getValueAt(row,column).toString());
            if (answer==0) {
                notesImpl.Delete(nid);
                tblNotes.setModel(notesImpl.notesTableModel());
                txtTitle.setText("");
                txtDetails.setText("");
                row = -1;
            }
        }else {
            JOptionPane.showMessageDialog(this,"Please make a choose from the list.");
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        txtTitle = new JTextField();
        scrollPane1 = new JScrollPane();
        txtDetails = new JTextArea();
        btnDelete = new JButton();
        scrollPane2 = new JScrollPane();
        tblNotes = new JTable();
        btnUpdate = new JButton();
        btnSave = new JButton();
        lblError = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("Notes"));
            panel1.setBackground(new Color(153, 255, 255));

            //---- label1 ----
            label1.setText("Title");

            //---- label2 ----
            label2.setText("Details");

            //---- txtTitle ----
            txtTitle.setBackground(Color.white);

            //======== scrollPane1 ========
            {

                //---- txtDetails ----
                txtDetails.setBackground(Color.white);
                scrollPane1.setViewportView(txtDetails);
            }

            //---- btnDelete ----
            btnDelete.setText("Delete");
            btnDelete.setBackground(new Color(204, 204, 204));
            btnDelete.addActionListener(e -> btnDelete(e));

            //======== scrollPane2 ========
            {

                //---- tblNotes ----
                tblNotes.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        tblNotesKeyReleased(e);
                    }
                });
                tblNotes.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        tblNotesMouseClicked(e);
                    }
                });
                scrollPane2.setViewportView(tblNotes);
            }

            //---- btnUpdate ----
            btnUpdate.setText("Update");
            btnUpdate.setBackground(new Color(204, 204, 204));
            btnUpdate.addActionListener(e -> btnUpdate(e));

            //---- btnSave ----
            btnSave.setText("Save");
            btnSave.setBackground(Color.lightGray);
            btnSave.setIcon(null);
            btnSave.addActionListener(e -> btnSave(e));

            //---- lblError ----
            lblError.setForeground(Color.red);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(lblError, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(402, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTitle, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(btnDelete, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUpdate, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSave, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17))))
                    .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSave, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollPane1))
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblError, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JTextField txtTitle;
    private JScrollPane scrollPane1;
    private JTextArea txtDetails;
    private JButton btnDelete;
    private JScrollPane scrollPane2;
    private JTable tblNotes;
    private JButton btnUpdate;
    private JButton btnSave;
    private JLabel lblError;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
