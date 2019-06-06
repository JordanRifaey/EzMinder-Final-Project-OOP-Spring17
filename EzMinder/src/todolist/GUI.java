package todolist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
//import org.apache.derby.jdbc.*;

public class GUI extends JFrame {
//---------------------------------------------------------------------------Variables------------------------------------------------------------

    private Connection con;
    private Statement stmt;
    private PreparedStatement pstmtInsertList;
    private PreparedStatement pstmtInsertTask;
    private PreparedStatement pstmtUpdate;
    private PreparedStatement pstmtSelect;
    private ResultSet rs;
    private String dbURI = "jdbc:derby:ToDo;create=true";
    private ArrayList<Object> lists;
    private int jListIndex;
    private boolean editMode;
//---------------------------------------------------------------------------GUI------------------------------------------------------------------

    private GUI() {
        initComponents();
        lists = new ArrayList();
        populateGUI();
        setLocationRelativeTo(null);
        loadDatabase();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                saveToDatabase();
                System.exit(0);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddTask1 = new javax.swing.JButton();
        btnAddTask2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        btn3 = new javax.swing.JButton();
        scrollTaskDescription = new javax.swing.JScrollPane();
        txtTaskDescription = new javax.swing.JTextArea();
        btn4 = new javax.swing.JButton();
        checkboxTaskStatus = new javax.swing.JCheckBox();
        txtTaskTitle = new javax.swing.JTextField();
        lblTaskStatus = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();
        scrolljList = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Exit = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        btnAddTask1.setText("Add Task");
        btnAddTask1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTask1ActionPerformed(evt);
            }
        });

        btnAddTask2.setText("Add Task");
        btnAddTask2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTask2ActionPerformed(evt);
            }
        });

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ez-Minder");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                finalThings(evt);
            }
        });

        btn3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn3.setText("Add Task");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        txtTaskDescription.setColumns(20);
        txtTaskDescription.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtTaskDescription.setRows(5);
        txtTaskDescription.setText("Task description ...");
        txtTaskDescription.setWrapStyleWord(true);
        txtTaskDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTaskDescriptionKeyReleased(evt);
            }
        });
        scrollTaskDescription.setViewportView(txtTaskDescription);

        btn4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn4.setText("Delete Task");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        checkboxTaskStatus.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        checkboxTaskStatus.setText(" Incomplete");
        checkboxTaskStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxTaskStatusActionPerformed(evt);
            }
        });
        checkboxTaskStatus.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                checkboxTaskStatusPropertyChange(evt);
            }
        });

        txtTaskTitle.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtTaskTitle.setText("Task Title ...");
        txtTaskTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTaskTitleKeyReleased(evt);
            }
        });

        lblTaskStatus.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblTaskStatus.setText("Task Status:");

        jComboBox.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });

        jList.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListValueChanged(evt);
            }
        });
        scrolljList.setViewportView(jList);

        jMenu1.setText("File");

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jMenu1.add(Exit);

        Save.setText("Save");
        Save.setToolTipText("This program saves on exit");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jMenu1.add(Save);

        menuBar.add(jMenu1);

        jMenu4.setText("Edit");

        jMenuItem1.setText("Add List");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem2.setText("Delete List");
        jMenu4.add(jMenuItem2);

        menuBar.add(jMenu4);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrolljList, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTaskStatus)
                        .addGap(18, 18, 18)
                        .addComponent(checkboxTaskStatus))
                    .addComponent(txtTaskTitle, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollTaskDescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTaskStatus)
                    .addComponent(checkboxTaskStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTaskTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollTaskDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn4)
                            .addComponent(btn3)))
                    .addComponent(scrolljList))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//---------------------------------------------------------------------------Database things------------------------------------------------------

    private void addList() {
        String listName = JOptionPane.showInputDialog(null, "List Name:", "To Do", JOptionPane.QUESTION_MESSAGE);
        int listID;
        if (jComboBox.getSelectedIndex() > -1) {
            listID = jComboBox.getSelectedIndex();
        } else {
            listID = 0;
        }
        List list = new List(listName);
        lists.add(list);
        reloadBox();
        jComboBox.setSelectedIndex(lists.size() - 1);
        txtTaskTitle.selectAll();
        txtTaskTitle.requestFocus();
    }
    private void checkboxTaskStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxTaskStatusActionPerformed
        editModeInit();
        if (jList.getSelectedIndex() > -1) {
            if (checkboxTaskStatus.isSelected()) {
                checkboxTaskStatus.setText("Completed");
                List list = (List) lists.get(jComboBox.getSelectedIndex());
                ArrayList tasks = list.getTasks();
                Task task = (Task) tasks.get(jList.getSelectedIndex());
                task.setCompleted(true);
                tasks.set(jList.getSelectedIndex(), task);
                list.setTasks(tasks);
            } else {
                checkboxTaskStatus.setText("Incomplete");
                List list = (List) lists.get(jComboBox.getSelectedIndex());
                ArrayList tasks = list.getTasks();
                Task task = (Task) tasks.get(jList.getSelectedIndex());
                task.setCompleted(false);
                tasks.set(jList.getSelectedIndex(), task);
                list.setTasks(tasks);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please create a task first.", "To Do", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_checkboxTaskStatusActionPerformed
    private void removeList() {
        int index = jComboBox.getSelectedIndex();
        if (index >= 0) {
            lists.remove(index);
            reloadBox();
        } else {
            JOptionPane.showMessageDialog(null, "Please create a list first.", "To Do", JOptionPane.ERROR_MESSAGE);
        }
        reloadList();
    }
    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        saveToDatabase();
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        int comboIndex = jComboBox.getSelectedIndex();
        int listIndex = jList.getSelectedIndex();
        if (editMode == false) {
            if (comboIndex >= 0) {
                if (!txtTaskTitle.getText().equalsIgnoreCase("")) {
                    List list = (List) lists.get(comboIndex);
                    if (listIndex == -1) {
                        if (list.getTasks().isEmpty()) {
                            list.addTask(txtTaskTitle.getText(), txtTaskDescription.getText(), checkboxTaskStatus.isSelected(), 0, comboIndex);
                        } else {
                            list.addTask(txtTaskTitle.getText(), txtTaskDescription.getText(), checkboxTaskStatus.isSelected(), list.getTasks().size(), comboIndex);
                        }
                        reloadList();
                        jList.setSelectedIndex(jList.getModel().getSize() - 1);
                    } else {
                        list.addTask("Task Title ...", "", false);
                        reloadList();
                        jList.setSelectedIndex(jList.getModel().getSize() - 1);
                        txtTaskTitle.selectAll();
                        txtTaskTitle.requestFocus();
                    }
                } else if (txtTaskTitle.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a task title.", "To Do", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please create a list first.", "To Do", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            discardEdits();
        }
    }//GEN-LAST:event_btn3ActionPerformed

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        reloadList();
    }//GEN-LAST:event_jComboBoxActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        if (editMode == false) {
            int comboIndex = jComboBox.getSelectedIndex();
            int listIndex = jList.getSelectedIndex();
            if (comboIndex >= 0 && listIndex >= 0) {
                List list = (List) lists.get(comboIndex);
                list.getTasks().remove(jList.getSelectedIndex());
                if (jList.getModel().getSize() == 1) {
                    txtTaskTitle.setText("");
                    txtTaskDescription.setText("");
                    checkboxTaskStatus.setSelected(false);
                } else {
                    reloadList();
                    reloadTaskInfo();
                }
                reloadList();
            } else if (comboIndex < 0) {
                JOptionPane.showMessageDialog(null, "Please create a list and task first.", "To Do", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            saveEdits();
        }
    }//GEN-LAST:event_btn4ActionPerformed

    private void btnAddTask1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTask1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddTask1ActionPerformed

    private void btnAddTask2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTask2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddTask2ActionPerformed

    private void txtTaskTitleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTaskTitleKeyReleased
        editModeInit();
        if (txtTaskDescription.getText().equalsIgnoreCase("Task description ...")) {
            txtTaskDescription.setText("");
        }
    }//GEN-LAST:event_txtTaskTitleKeyReleased

    private void txtTaskDescriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTaskDescriptionKeyReleased
        editModeInit();
    }//GEN-LAST:event_txtTaskDescriptionKeyReleased

    private void checkboxTaskStatusPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_checkboxTaskStatusPropertyChange

    }//GEN-LAST:event_checkboxTaskStatusPropertyChange

    private void jListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListValueChanged
        reloadTaskInfo();
        if (editMode) {
            discardEdits();
        }
    }//GEN-LAST:event_jListValueChanged

    private void finalThings(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_finalThings
        // TODO add your handling code here:
    }//GEN-LAST:event_finalThings

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        saveToDatabase();
    }//GEN-LAST:event_SaveActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        addList();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
//-----------------------------------------------------------------Other Methods-------------------------------------------------------------------    

    private void saveToDatabase() {
        try {
            String path = System.getProperty("user.home", ".") + "\\ToDo\\todo.data";
            File f = new File(path);
            if (!f.exists()) {
                File file = new File(path);
                file.getParentFile().mkdirs();
                FileWriter writer = new FileWriter(file);
            }
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(lists);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        //populateDB();
    }

    private void loadDatabase() {
        try {
            String path = System.getProperty("user.home", ".") + "\\ToDo\\todo.data";
            File f = new File(path);
            if (f.exists()) {
                FileInputStream fos = new FileInputStream(path);
                ObjectInputStream oos = new ObjectInputStream(fos);
                ArrayList x = (ArrayList) oos.readObject();
                lists = x;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        reloadBox();
        reloadList();
        reloadTaskInfo();
        //populateDB();
    }

    private void reloadBox() {
        String labels[] = new String[lists.size()];
        int i = 0;
        for (Object obj : lists) {
            List list = (List) obj;
            labels[i] = list.getTitle();
            i++;
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(labels);
        jComboBox.setModel(model);
    }

    private void reloadList() {
        int comboIndex = jComboBox.getSelectedIndex();
        int jListIndex = jList.getSelectedIndex();
        if (comboIndex >= 0) {
            List list = (List) lists.get(comboIndex);
            DefaultListModel model = new DefaultListModel();
            int i = 0;
            for (Object obj : list.getTasks()) {
                Task task = (Task) obj;
                model.add(i, task.getTitle());
                i++;
            }
            jList.setModel(model);
            jList.setSelectedIndex(jListIndex);
        } else {
            DefaultListModel model = new DefaultListModel();
            jList.setModel(model);
        }
    }

    private void reloadTaskInfo() {
        int comboIndex = jComboBox.getSelectedIndex();
        int listIndex = jList.getSelectedIndex();
        if (listIndex > -1) {
            List list = (List) lists.get(comboIndex);
            Task task = (Task) list.getTasks().get(listIndex);
            txtTaskTitle.setText(task.getTitle());
            txtTaskDescription.setText(task.getDescription());
            if (task.isCompleted()) {
                checkboxTaskStatus.setSelected(true);
            } else {
                checkboxTaskStatus.setSelected(false);
            }
        } else {
            checkboxTaskStatus.setSelected(false);
            txtTaskTitle.setText("");
            txtTaskDescription.setText("");
        }
    }

    private void editModeInit() {
        jListIndex = jList.getSelectedIndex();
        if (jList.getSelectedIndex() != -1 && editMode == false) {
            editMode = true;
            btn3.setText("Discard");
            btn3.setSize(89, 23);
            btn4.setText("Save");
            btn4.setSize(89, 23);
        }
    }

    private void saveEdits() {
        if (!txtTaskTitle.getText().equalsIgnoreCase("")) {
            int comboIndex = jComboBox.getSelectedIndex();
            int listIndex = jList.getSelectedIndex();
            List list = (List) lists.get(comboIndex);
            Task task = (Task) list.getTasks().get(listIndex);
            task.setTitle(txtTaskTitle.getText(), list.getListID());
            task.setDescription(txtTaskDescription.getText(), list.getListID());
            task.setCompleted(checkboxTaskStatus.isSelected());
            if (checkboxTaskStatus.isSelected()) {
                checkboxTaskStatus.setText("Completed");
            } else {
                checkboxTaskStatus.setText("Incomplete");
            }
            jList.setSelectedIndex(listIndex);
            btn3.setText("Add Task");
            btn3.setSize(89, 23);
            btn4.setText("Delete Task");
            btn4.setSize(89, 23);
            reloadList();
            editMode = false;
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a task title.", "To Do", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void discardEdits() {
        btn3.setText("Add Task");
        btn3.setSize(89, 23);
        btn4.setText("Delete Task");
        btn4.setSize(89, 23);
        editMode = false;
        jList.setSelectedIndex(jListIndex);
        reloadList();
        reloadTaskInfo();
        if (checkboxTaskStatus.isSelected()) {
            checkboxTaskStatus.setText("Completed");
        } else {
            checkboxTaskStatus.setText("Incomplete");
        }
    }

//    private void populateArrayList() {
//        try {
//
//            List temp;
//            boolean completeState = false;
//
//            //populate each list
////            con = DriverManager.getConnection(dbURI);
//            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            rs = stmt.executeQuery("SELECT * FROM list");
//            rs.first();//list result set
//            if (rs.next()) {//if there are rows in this result set
//                while (rs.next()) {//while there are rows in this result set
//                    String listName = rs.getString(1);
//                    int listID = rs.getInt(2);//get the list information
//                    temp = new List(listName, listID);//create a new list object
//                    lists.add(temp);//add the object to lists
//                    rs.next();//go to the next row in the list table
//                }
//                rs.close();
//                stmt.close();
//
//                //populate tasks for each list
//                stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//                rs = stmt.executeQuery("SELECT * FROM task");
//                rs.first();//task result set
//
//                if (rs.next()) {//if there are rows in this result set
//                    for (int i = 0; i < lists.size() - 1; i++) {//for every list in lists
//                        while (rs.next()) {//while there are rows in this result set
//                            String taskName = rs.getString(1);
//                            String taskDesc = rs.getString(2);
//                            int isComplete = rs.getInt(3);
//
//                            if (isComplete == 1) {
//                                completeState = true;
//                            } else if (isComplete == 0) {
//                                completeState = false;
//                            }
//
//                            int taskID = rs.getInt(4);
//                            int listID = rs.getInt(5);//get all the task information
//                            temp = (List) lists.get(listID);//get the right list for the task
//                            temp.addTask(taskName, taskDesc, completeState, taskID, listID);//add the task to that list
//                            lists.set(taskID, temp);//set the list in lists with the task-updated list object
//                            rs.next();
//                        }
//                    }
//                }
//                rs.close();
//                stmt.close();
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(this, ex.getMessage());
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(this, ex.getMessage());
//            }
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(this, ex.getMessage());
//            }
//        }
//    }
    private void populateGUI() {
        if (lists.isEmpty() == false) {
            List list = (List) lists.get(1);

            if (list.getTasks().isEmpty() == false) {
                jList.setSelectedIndex(0);
            }
        }
    }

//-------------------------------------------------------------------Main Method-------------------------------------------------------------------    
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem Save;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btnAddTask1;
    private javax.swing.JButton btnAddTask2;
    private javax.swing.JCheckBox checkboxTaskStatus;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JList<String> jList;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel lblTaskStatus;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JScrollPane scrollTaskDescription;
    private javax.swing.JScrollPane scrolljList;
    private javax.swing.JTextArea txtTaskDescription;
    private javax.swing.JTextField txtTaskTitle;
    // End of variables declaration//GEN-END:variables
}
