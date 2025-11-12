/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cledatabase;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import jnafilechooser.api.JnaFileChooser;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStream;  
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;  
import static org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK;
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author RemixTheIdiot
 */
public class MainFrame extends javax.swing.JFrame {
    
    // =========================================================================
    // GLOBAL VARIABLES
    // =========================================================================
    
    int tabindex = 0;
    
    DefaultTableModel validList = new DefaultTableModel();
    
    // =========================================================================
    // Student Tab Global Variables
    // =========================================================================
    
    DefaultTableModel studentValidList = new DefaultTableModel();
    JTable studentValid = new JTable(studentValidList);
    
    // =========================================================================
    // Department Tab Global Variables
    // =========================================================================
    
    DefaultTableModel deptValidList = new DefaultTableModel();
    JTable deptValid = new JTable(deptValidList);
    
    // =========================================================================
    // Credentials Tab Global Variables
    // =========================================================================
    
    //ArrayList<List<String>> listStudents = new ArrayList<List<String>>();
    //DefaultTableModel validList = new DefaultTableModel();
    DefaultTableModel credvalidList = new DefaultTableModel();
    DefaultTableModel enrollvalidList = new DefaultTableModel();
    JTable credValid = new JTable(credvalidList);
    JTable enrollValid = new JTable(enrollvalidList);
    
    // =========================================================================
    // Schedule Tab Global Variables
    // =========================================================================
    
    DefaultTableModel schedvalidList = new DefaultTableModel();
    JTable schedValid = new JTable(schedvalidList);
    
    // =========================================================================
    // GLOBAL METHODS
    // =========================================================================
    
    // SORT BY COLUMN METHOD - 2d array method to sort an array of strings based on a column
    
    public static void sortbyColumn(String a[][], int c){      
      Arrays.sort(a, (x, y) -> x[c].compareTo(y[c]));
    }
    
    // SORT BY Number METHOD - 2d array method to sort an array of integers based on a column
    
    public static void sortbyNumber(int a[][], int c){      
      Arrays.sort(a, (x, y) -> Integer.compare(x[c],y[c])); 
    }
    
    // SORT BY DATE METHOD - 2d array method to sort an array of dates
    
    public static void sortbyDate(Date a[][], int c){      
      Arrays.sort(a, (x, y) -> x[c].compareTo(y[c]));
    }
    
    // IS NUMERIC METHOD - simple method to check if a string contains numbers
    
    public static boolean isNumeric(String str) { 
        try {  
          Double.parseDouble(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
    }
    
    public static boolean getStringBool(String str) {
        boolean con = false;
        if (str.equals("true")) { con = true; }
        if (str.equals("false")) { con = false; }
        return con;
    }
    
    public static void pause(int w) {
        try {
            Thread.sleep(w);
        } catch (InterruptedException ex) {
            System.getLogger(MainFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    // =========================================================================
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelCurrentTab = new javax.swing.JLabel();
        labelCurrentDesc = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        buttonExportAll = new javax.swing.JButton();
        buttonImportAll = new javax.swing.JButton();
        buttonExport = new javax.swing.JButton();
        buttonImport = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelDashboard = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelTotalStudents = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelActiveStudents = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        labelTotalDepts = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        labelTotalCreds = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        labelCompletionRate = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRecentStudents = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableRecentDepts = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableRecentCreds = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        panQuickAnalytics = new javax.swing.JScrollPane();
        panStudPie = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tablePerform = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaLoaded = new javax.swing.JTextArea();
        buttonDashboard = new javax.swing.JButton();
        panelStudents = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        textFieldStudentFilter = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableStudents = new javax.swing.JTable();
        comboStudentFilter = new javax.swing.JComboBox<>();
        buttonStudentFilter = new javax.swing.JButton();
        buttonStudentRowAdd = new javax.swing.JButton();
        buttonStudentDelete = new javax.swing.JButton();
        buttonStudentValidate = new javax.swing.JButton();
        buttonStudentFilterReset = new javax.swing.JButton();
        buttonStudentSort = new javax.swing.JButton();
        buttonStudentRowRemove = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        buttonAddStudent = new javax.swing.JButton();
        textStudentNumber = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        textStudentName = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        textStudentEmail = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        textStudentEMailAlt = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        comboStudentStatus = new javax.swing.JComboBox<>();
        buttonStudentUpdate = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        textStudentDept = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        textStudentPhone = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        textStudentFB = new javax.swing.JTextField();
        panelDept = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        textFieldDeptFilter = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableDepts = new javax.swing.JTable();
        comboDeptFilter = new javax.swing.JComboBox<>();
        buttonDeptFilter = new javax.swing.JButton();
        buttonDeptRowAdd = new javax.swing.JButton();
        buttonDeptDelete = new javax.swing.JButton();
        buttonDeptValidate = new javax.swing.JButton();
        buttonDeptFilterReset = new javax.swing.JButton();
        buttonDeptSort = new javax.swing.JButton();
        buttonDeptRowRemove = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        textDeptName = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        textDeptHead = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        comboDeptStatus = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        buttonAddDept = new javax.swing.JButton();
        buttonDeptUpdate = new javax.swing.JButton();
        spinnerDeptStudents = new javax.swing.JSpinner();
        spinnerDeptDate = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        panelCredList = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableCreds = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableEnrolls = new javax.swing.JTable();
        jLabel41 = new javax.swing.JLabel();
        textFieldFilterEnroll = new javax.swing.JTextField();
        buttonFilterEnroll = new javax.swing.JButton();
        buttonSortEnroll = new javax.swing.JButton();
        comboFilterEnroll = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        buttonNewCred = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        textFieldFilterCred = new javax.swing.JTextField();
        buttonFilterCred = new javax.swing.JButton();
        comboFilterCred = new javax.swing.JComboBox<>();
        buttonDelAll = new javax.swing.JButton();
        buttonValAll = new javax.swing.JButton();
        buttonFilterCredReset = new javax.swing.JButton();
        buttonSortCred = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel20 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        calendarSessions = new com.toedter.calendar.JCalendar();
        jLabel21 = new javax.swing.JLabel();
        buttonAddSession = new javax.swing.JButton();
        buttonValidDate = new javax.swing.JButton();
        buttonRemoveDate = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        panelSchedView = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableSchedList = new javax.swing.JTable();
        jPanel35 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        labelSessionTotal2 = new javax.swing.JLabel();
        labelSessionComplete2 = new javax.swing.JLabel();
        labelSessionOngoing2 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        labelSessionRate2 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        labelSessionAttend2 = new javax.swing.JLabel();
        buttonSchedSort = new javax.swing.JButton();
        comboSchedFilter = new javax.swing.JComboBox<>();
        buttonSchedFilter = new javax.swing.JButton();
        textFieldSchedFilter = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        buttonSchedFilterReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CLE Database");
        setBackground(new java.awt.Color(187, 187, 187));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("CLE Database");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Management System");

        labelCurrentTab.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelCurrentTab.setText("Dashboard");

        labelCurrentDesc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelCurrentDesc.setForeground(new java.awt.Color(153, 153, 153));
        labelCurrentDesc.setText("General Overview of the Database");

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("About");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonExportAll.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonExportAll.setText("Export for all Tabs");
        buttonExportAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExportAllActionPerformed(evt);
            }
        });

        buttonImportAll.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonImportAll.setText("Import for All Tabs");
        buttonImportAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImportAllActionPerformed(evt);
            }
        });

        buttonExport.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonExport.setText("Export Current Tab");
        buttonExport.setToolTipText("Exports validated data of currently selected tab.");
        buttonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExportActionPerformed(evt);
            }
        });

        buttonImport.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonImport.setText("Import for Current Tab");
        buttonImport.setToolTipText("Load a sheet as validated data to the current tab.");
        buttonImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImportActionPerformed(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Total Students:");

        labelTotalStudents.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelTotalStudents.setText("0");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Active Students: ");

        labelActiveStudents.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelActiveStudents.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(labelTotalStudents)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelActiveStudents)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTotalStudents)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(labelActiveStudents))
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Departments:");

        labelTotalDepts.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelTotalDepts.setText("0");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(labelTotalDepts))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTotalDepts)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Microcredentials");

        labelTotalCreds.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelTotalCreds.setText("0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(labelTotalCreds))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTotalCreds)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Completion Rate:");

        labelCompletionRate.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelCompletionRate.setText("0%");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(labelCompletionRate))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCompletionRate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Recent Students");

        tableRecentStudents.setAutoCreateRowSorter(true);
        tableRecentStudents.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tableRecentStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Name", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRecentStudents.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableRecentStudents.setRowHeight(18);
        jScrollPane2.setViewportView(tableRecentStudents);
        if (tableRecentStudents.getColumnModel().getColumnCount() > 0) {
            tableRecentStudents.getColumnModel().getColumn(0).setResizable(false);
            tableRecentStudents.getColumnModel().getColumn(0).setPreferredWidth(200);
            tableRecentStudents.getColumnModel().getColumn(1).setResizable(false);
            tableRecentStudents.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 80, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Department Distribution");

        tableRecentDepts.setAutoCreateRowSorter(true);
        tableRecentDepts.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tableRecentDepts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, ""}
            },
            new String [] {
                "Dept.", "Students"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRecentDepts.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane3.setViewportView(tableRecentDepts);
        if (tableRecentDepts.getColumnModel().getColumnCount() > 0) {
            tableRecentDepts.getColumnModel().getColumn(0).setResizable(false);
            tableRecentDepts.getColumnModel().getColumn(0).setPreferredWidth(200);
            tableRecentDepts.getColumnModel().getColumn(1).setResizable(false);
            tableRecentDepts.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 36, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Microcredentials Overview");

        tableRecentCreds.setAutoCreateRowSorter(true);
        tableRecentCreds.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tableRecentCreds.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Credential", "Enrolled", "Duration"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRecentCreds.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane4.setViewportView(tableRecentCreds);
        if (tableRecentCreds.getColumnModel().getColumnCount() > 0) {
            tableRecentCreds.getColumnModel().getColumn(0).setResizable(false);
            tableRecentCreds.getColumnModel().getColumn(0).setPreferredWidth(200);
            tableRecentCreds.getColumnModel().getColumn(1).setResizable(false);
            tableRecentCreds.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableRecentCreds.getColumnModel().getColumn(2).setResizable(false);
            tableRecentCreds.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("Analytics");

        jTabbedPane5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTabbedPane5.addTab("Credential Completion", panQuickAnalytics);

        javax.swing.GroupLayout panStudPieLayout = new javax.swing.GroupLayout(panStudPie);
        panStudPie.setLayout(panStudPieLayout);
        panStudPieLayout.setHorizontalGroup(
            panStudPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );
        panStudPieLayout.setVerticalGroup(
            panStudPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
        );

        jTabbedPane5.addTab("Student Status", panStudPie);

        tablePerform.setAutoCreateRowSorter(true);
        tablePerform.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tablePerform.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Name", "Credential", "Score"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(tablePerform);
        if (tablePerform.getColumnModel().getColumnCount() > 0) {
            tablePerform.getColumnModel().getColumn(0).setResizable(false);
            tablePerform.getColumnModel().getColumn(0).setPreferredWidth(250);
            tablePerform.getColumnModel().getColumn(1).setResizable(false);
            tablePerform.getColumnModel().getColumn(1).setPreferredWidth(250);
            tablePerform.getColumnModel().getColumn(2).setResizable(false);
            tablePerform.getColumnModel().getColumn(2).setPreferredWidth(75);
        }

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Student Performance", jPanel19);

        jButton3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton3.setText("Export Analytics");
        jButton3.setToolTipText("Creates a png and xsxl file of the analytics at a specified folder");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jTabbedPane5))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Currently Loaded Files:");

        textAreaLoaded.setColumns(20);
        textAreaLoaded.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        textAreaLoaded.setLineWrap(true);
        textAreaLoaded.setRows(5);
        textAreaLoaded.setText("No file(s) loaded.\nThis is a blank database.");
        textAreaLoaded.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        textAreaLoaded.setEnabled(false);
        jScrollPane1.setViewportView(textAreaLoaded);

        buttonDashboard.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonDashboard.setText("Update Dashboard");
        buttonDashboard.setToolTipText("only reflects validated changes");
        buttonDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDashboardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDashboardLayout = new javax.swing.GroupLayout(panelDashboard);
        panelDashboard.setLayout(panelDashboardLayout);
        panelDashboardLayout.setHorizontalGroup(
            panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDashboardLayout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDashboardLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonDashboard))
                            .addComponent(jScrollPane1)))
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDashboardLayout.setVerticalGroup(
            panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDashboardLayout.createSequentialGroup()
                        .addGroup(panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(buttonDashboard))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 412, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dashboard", panelDashboard);

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("Student Search");

        textFieldStudentFilter.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tableStudents.setAutoCreateRowSorter(true);
        tableStudents.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tableStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student Number", "Name", "Email", "Alt. Email", "Course/Year/Section", "Phone Number", "Facebook Account", "Status"
            }
        ));
        tableStudents.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableStudents.setRowHeight(18);
        tableStudents.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tableStudentsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableStudentsFocusLost(evt);
            }
        });
        tableStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableStudentsMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableStudents);
        if (tableStudents.getColumnModel().getColumnCount() > 0) {
            tableStudents.getColumnModel().getColumn(0).setResizable(false);
            tableStudents.getColumnModel().getColumn(0).setPreferredWidth(150);
            tableStudents.getColumnModel().getColumn(1).setResizable(false);
            tableStudents.getColumnModel().getColumn(1).setPreferredWidth(250);
            tableStudents.getColumnModel().getColumn(2).setResizable(false);
            tableStudents.getColumnModel().getColumn(2).setPreferredWidth(350);
            tableStudents.getColumnModel().getColumn(3).setResizable(false);
            tableStudents.getColumnModel().getColumn(3).setPreferredWidth(350);
            tableStudents.getColumnModel().getColumn(4).setResizable(false);
            tableStudents.getColumnModel().getColumn(4).setPreferredWidth(250);
            tableStudents.getColumnModel().getColumn(5).setResizable(false);
            tableStudents.getColumnModel().getColumn(5).setPreferredWidth(150);
            tableStudents.getColumnModel().getColumn(6).setResizable(false);
            tableStudents.getColumnModel().getColumn(6).setPreferredWidth(250);
            tableStudents.getColumnModel().getColumn(7).setResizable(false);
            tableStudents.getColumnModel().getColumn(7).setPreferredWidth(100);
        }

        comboStudentFilter.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboStudentFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student Number", "Student Name", "Student Email", "Alt Email", "Course/Year/Section", "Phone Number", "Facebook Account", "Status" }));

        buttonStudentFilter.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonStudentFilter.setText("Search by:");
        buttonStudentFilter.setToolTipText("List must be Validated before performing.");
        buttonStudentFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStudentFilterActionPerformed(evt);
            }
        });

        buttonStudentRowAdd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonStudentRowAdd.setText("Insert New Row");
        buttonStudentRowAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStudentRowAddActionPerformed(evt);
            }
        });

        buttonStudentDelete.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonStudentDelete.setText("Delete All Entries");
        buttonStudentDelete.setToolTipText("only clears the view. validate list in order to complete purge.");
        buttonStudentDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStudentDeleteActionPerformed(evt);
            }
        });

        buttonStudentValidate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonStudentValidate.setText("Validate List");
        buttonStudentValidate.setToolTipText("Updates the internal database for use in the exported excel sheet.");
        buttonStudentValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStudentValidateActionPerformed(evt);
            }
        });

        buttonStudentFilterReset.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonStudentFilterReset.setText("View All");
        buttonStudentFilterReset.setToolTipText("Resets search and sort view to view list when it was last validated.");
        buttonStudentFilterReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStudentFilterResetActionPerformed(evt);
            }
        });

        buttonStudentSort.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonStudentSort.setText("Sort by:");
        buttonStudentSort.setToolTipText("List must be Validated before performing.");
        buttonStudentSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStudentSortActionPerformed(evt);
            }
        });

        buttonStudentRowRemove.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonStudentRowRemove.setText("Remove Selected Rows");
        buttonStudentRowRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStudentRowRemoveActionPerformed(evt);
            }
        });

        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel27.setText("[Student Wizard]");

        buttonAddStudent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonAddStudent.setText("Add Student");
        buttonAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddStudentActionPerformed(evt);
            }
        });

        textStudentNumber.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel28.setText("Student Number: ");

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setText("Student Name:");

        textStudentName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel30.setText("Student Email:");

        textStudentEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel31.setText("Alternate Email:");

        textStudentEMailAlt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel32.setText("Status:");

        comboStudentStatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboStudentStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive", "Graduated" }));

        buttonStudentUpdate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonStudentUpdate.setText("Update Student");
        buttonStudentUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStudentUpdateActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel33.setText("Course/Yr/Sec:");

        textStudentDept.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel42.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel42.setText("Phone Number:");

        textStudentPhone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel43.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel43.setText("Facebook Acc.:");

        textStudentFB.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(buttonAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonStudentUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33)
                            .addComponent(jLabel42)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textStudentFB)
                            .addComponent(textStudentPhone)
                            .addComponent(textStudentDept)
                            .addComponent(comboStudentStatus, 0, 249, Short.MAX_VALUE)
                            .addComponent(textStudentEMailAlt)
                            .addComponent(textStudentEmail)
                            .addComponent(textStudentName)
                            .addComponent(textStudentNumber))))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textStudentNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textStudentEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textStudentEMailAlt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textStudentDept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textStudentPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textStudentFB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboStudentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonAddStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonStudentUpdate)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelStudentsLayout = new javax.swing.GroupLayout(panelStudents);
        panelStudents.setLayout(panelStudentsLayout);
        panelStudentsLayout.setHorizontalGroup(
            panelStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStudentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelStudentsLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelStudentsLayout.createSequentialGroup()
                        .addGroup(panelStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelStudentsLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldStudentFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelStudentsLayout.createSequentialGroup()
                                .addComponent(buttonStudentRowAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonStudentRowRemove)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelStudentsLayout.createSequentialGroup()
                                .addComponent(buttonStudentFilter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonStudentSort)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonStudentFilterReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonStudentValidate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonStudentDelete))
                            .addComponent(comboStudentFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelStudentsLayout.setVerticalGroup(
            panelStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStudentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(textFieldStudentFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonStudentFilter)
                    .addComponent(buttonStudentFilterReset)
                    .addComponent(buttonStudentSort)
                    .addComponent(buttonStudentValidate)
                    .addComponent(buttonStudentDelete))
                .addGap(6, 6, 6)
                .addGroup(panelStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonStudentRowAdd)
                    .addComponent(comboStudentFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonStudentRowRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Students", panelStudents);

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("Department Search");

        textFieldDeptFilter.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tableDepts.setAutoCreateRowSorter(true);
        tableDepts.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tableDepts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Dept Head", "Students", "Status", "Establish Date"
            }
        ));
        tableDepts.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tableDepts.setRowHeight(18);
        tableDepts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDeptsMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tableDepts);
        if (tableDepts.getColumnModel().getColumnCount() > 0) {
            tableDepts.getColumnModel().getColumn(0).setResizable(false);
            tableDepts.getColumnModel().getColumn(0).setPreferredWidth(250);
            tableDepts.getColumnModel().getColumn(1).setResizable(false);
            tableDepts.getColumnModel().getColumn(1).setPreferredWidth(250);
            tableDepts.getColumnModel().getColumn(2).setResizable(false);
            tableDepts.getColumnModel().getColumn(2).setPreferredWidth(50);
            tableDepts.getColumnModel().getColumn(3).setResizable(false);
            tableDepts.getColumnModel().getColumn(3).setPreferredWidth(50);
            tableDepts.getColumnModel().getColumn(4).setResizable(false);
            tableDepts.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        comboDeptFilter.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboDeptFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Dept Head", "Students", "Status", "Establish" }));
        comboDeptFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDeptFilterActionPerformed(evt);
            }
        });

        buttonDeptFilter.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonDeptFilter.setText("Search by:");
        buttonDeptFilter.setToolTipText("List must be Validated before performing.");
        buttonDeptFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeptFilterActionPerformed(evt);
            }
        });

        buttonDeptRowAdd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonDeptRowAdd.setText("Insert New Row");
        buttonDeptRowAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeptRowAddActionPerformed(evt);
            }
        });

        buttonDeptDelete.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonDeptDelete.setText("Delete All Entries");
        buttonDeptDelete.setToolTipText("only clears the view. validate list in order to complete purge.");
        buttonDeptDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeptDeleteActionPerformed(evt);
            }
        });

        buttonDeptValidate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonDeptValidate.setText("Validate List");
        buttonDeptValidate.setToolTipText("Updates the internal database for use in the exported excel sheet.");
        buttonDeptValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeptValidateActionPerformed(evt);
            }
        });

        buttonDeptFilterReset.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonDeptFilterReset.setText("View All");
        buttonDeptFilterReset.setToolTipText("Resets search and sort view to view list when it was last validated.");
        buttonDeptFilterReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeptFilterResetActionPerformed(evt);
            }
        });

        buttonDeptSort.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonDeptSort.setText("Sort by:");
        buttonDeptSort.setToolTipText("List must be Validated before performing.");
        buttonDeptSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeptSortActionPerformed(evt);
            }
        });

        buttonDeptRowRemove.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonDeptRowRemove.setText("Remove Selected Rows");
        buttonDeptRowRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeptRowRemoveActionPerformed(evt);
            }
        });

        jPanel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel34.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel34.setText("[Department Wizard]");

        jLabel35.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel35.setText("Dept. Name:");

        textDeptName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel36.setText("Dept. Head:");

        textDeptHead.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel37.setText("Students:");

        jLabel39.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel39.setText("Status:");

        comboDeptStatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboDeptStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));

        jLabel40.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel40.setText("Establish Date:");

        buttonAddDept.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonAddDept.setText("Add Department");
        buttonAddDept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddDeptActionPerformed(evt);
            }
        });

        buttonDeptUpdate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonDeptUpdate.setText("Update Department");
        buttonDeptUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeptUpdateActionPerformed(evt);
            }
        });

        spinnerDeptStudents.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        spinnerDeptStudents.setModel(new javax.swing.SpinnerNumberModel());

        spinnerDeptDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        spinnerDeptDate.setModel(new javax.swing.SpinnerNumberModel());

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel36)
                            .addComponent(jLabel35)
                            .addComponent(jLabel37)
                            .addComponent(jLabel40))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinnerDeptDate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboDeptStatus, 0, 249, Short.MAX_VALUE)
                            .addComponent(textDeptHead)
                            .addComponent(textDeptName)
                            .addComponent(spinnerDeptStudents)))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(buttonDeptUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(buttonAddDept, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDeptName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDeptHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(spinnerDeptStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDeptStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerDeptDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addGap(18, 18, 18)
                .addComponent(buttonAddDept)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonDeptUpdate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelDeptLayout = new javax.swing.GroupLayout(panelDept);
        panelDept.setLayout(panelDeptLayout);
        panelDeptLayout.setHorizontalGroup(
            panelDeptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDeptLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDeptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDeptLayout.createSequentialGroup()
                        .addGroup(panelDeptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDeptLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldDeptFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDeptLayout.createSequentialGroup()
                                .addComponent(buttonDeptRowAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonDeptRowRemove)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDeptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDeptLayout.createSequentialGroup()
                                .addComponent(buttonDeptFilter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDeptSort)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDeptFilterReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDeptValidate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDeptDelete))
                            .addComponent(comboDeptFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 180, Short.MAX_VALUE))
                    .addComponent(jScrollPane6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelDeptLayout.setVerticalGroup(
            panelDeptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDeptLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDeptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(textFieldDeptFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDeptFilter)
                    .addComponent(buttonDeptFilterReset)
                    .addComponent(buttonDeptDelete)
                    .addComponent(buttonDeptValidate)
                    .addComponent(buttonDeptSort))
                .addGap(6, 6, 6)
                .addGroup(panelDeptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDeptRowAdd)
                    .addComponent(comboDeptFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDeptRowRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDeptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Departments", panelDept);

        jTabbedPane2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jScrollPane7.setViewportView(panelCredList);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1252, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Overview", jPanel3);

        tableCreds.setAutoCreateRowSorter(true);
        tableCreds.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Code", "Name", "Dept.", "Duration", "Enrolled", "Completed"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCreds.setFocusable(false);
        jScrollPane8.setViewportView(tableCreds);
        if (tableCreds.getColumnModel().getColumnCount() > 0) {
            tableCreds.getColumnModel().getColumn(0).setResizable(false);
            tableCreds.getColumnModel().getColumn(0).setPreferredWidth(75);
            tableCreds.getColumnModel().getColumn(1).setResizable(false);
            tableCreds.getColumnModel().getColumn(1).setPreferredWidth(250);
            tableCreds.getColumnModel().getColumn(2).setResizable(false);
            tableCreds.getColumnModel().getColumn(2).setPreferredWidth(250);
            tableCreds.getColumnModel().getColumn(3).setResizable(false);
            tableCreds.getColumnModel().getColumn(3).setPreferredWidth(75);
            tableCreds.getColumnModel().getColumn(4).setResizable(false);
            tableCreds.getColumnModel().getColumn(4).setPreferredWidth(75);
            tableCreds.getColumnModel().getColumn(5).setResizable(false);
            tableCreds.getColumnModel().getColumn(5).setPreferredWidth(75);
        }

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1252, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Credentials List", jPanel17);

        tableEnrolls.setAutoCreateRowSorter(true);
        tableEnrolls.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Student No.", "Name", "Microcredential", "Status", "Enrollment Date", "Completion Date", "Score"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEnrolls.setFocusable(false);
        jScrollPane9.setViewportView(tableEnrolls);
        if (tableEnrolls.getColumnModel().getColumnCount() > 0) {
            tableEnrolls.getColumnModel().getColumn(0).setResizable(false);
            tableEnrolls.getColumnModel().getColumn(0).setPreferredWidth(150);
            tableEnrolls.getColumnModel().getColumn(1).setResizable(false);
            tableEnrolls.getColumnModel().getColumn(1).setPreferredWidth(250);
            tableEnrolls.getColumnModel().getColumn(2).setResizable(false);
            tableEnrolls.getColumnModel().getColumn(2).setPreferredWidth(250);
            tableEnrolls.getColumnModel().getColumn(3).setResizable(false);
            tableEnrolls.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableEnrolls.getColumnModel().getColumn(4).setResizable(false);
            tableEnrolls.getColumnModel().getColumn(4).setPreferredWidth(150);
            tableEnrolls.getColumnModel().getColumn(5).setResizable(false);
            tableEnrolls.getColumnModel().getColumn(5).setPreferredWidth(150);
            tableEnrolls.getColumnModel().getColumn(6).setResizable(false);
            tableEnrolls.getColumnModel().getColumn(6).setPreferredWidth(75);
        }

        jLabel41.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel41.setText("Enrollments Search");

        buttonFilterEnroll.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonFilterEnroll.setText("Search by:");
        buttonFilterEnroll.setToolTipText("List must be Validated before performing.");
        buttonFilterEnroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFilterEnrollActionPerformed(evt);
            }
        });

        buttonSortEnroll.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonSortEnroll.setText("Sort by:");
        buttonSortEnroll.setToolTipText("List must be Validated before performing.");
        buttonSortEnroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSortEnrollActionPerformed(evt);
            }
        });

        comboFilterEnroll.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboFilterEnroll.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student Number", "Student Name", "Microcredential", "Status", "Enrollment Date", "Completion Date", "Score" }));

        jButton4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton4.setText("View All");
        jButton4.setToolTipText("Resets search and sort view to view list when it was last validated.");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1252, Short.MAX_VALUE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldFilterEnroll, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonFilterEnroll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSortEnroll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboFilterEnroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldFilterEnroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(buttonFilterEnroll)
                    .addComponent(buttonSortEnroll)
                    .addComponent(comboFilterEnroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Enrollments", jPanel18);

        buttonNewCred.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonNewCred.setText("Insert New Credential");
        buttonNewCred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewCredActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setText("Credentials Search");

        textFieldFilterCred.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        buttonFilterCred.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonFilterCred.setText("Search by:");
        buttonFilterCred.setToolTipText("List must be Validated before performing.");
        buttonFilterCred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFilterCredActionPerformed(evt);
            }
        });

        comboFilterCred.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboFilterCred.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Code", "Name", "Department", "Duration", "Enrolled", "Completed" }));

        buttonDelAll.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonDelAll.setText("Delete All");
        buttonDelAll.setToolTipText("this will completely delete all information on the microcredentials tab. USE WITH CAUTION.");
        buttonDelAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDelAllActionPerformed(evt);
            }
        });

        buttonValAll.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonValAll.setText("Validate All");
        buttonValAll.setToolTipText("Updates the internal database for use in the exported excel sheet.");
        buttonValAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValAllActionPerformed(evt);
            }
        });

        buttonFilterCredReset.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonFilterCredReset.setText("View All");
        buttonFilterCredReset.setToolTipText("Resets search and sort view to view list when it was last validated.");
        buttonFilterCredReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFilterCredResetActionPerformed(evt);
            }
        });

        buttonSortCred.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonSortCred.setText("Sort by:");
        buttonSortCred.setToolTipText("List must be Validated before performing.");
        buttonSortCred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSortCredActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldFilterCred, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonFilterCred)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSortCred)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboFilterCred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFilterCredReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonValAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonDelAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNewCred)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonNewCred)
                    .addComponent(jLabel20)
                    .addComponent(textFieldFilterCred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFilterCred)
                    .addComponent(buttonDelAll)
                    .addComponent(buttonValAll)
                    .addComponent(buttonFilterCredReset)
                    .addComponent(buttonSortCred)
                    .addComponent(comboFilterCred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Microcredentials", jPanel4);

        jTabbedPane3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        calendarSessions.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        calendarSessions.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarSessionsPropertyChange(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel21.setText("Calendar");

        buttonAddSession.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonAddSession.setText("Schedule Session");
        buttonAddSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddSessionActionPerformed(evt);
            }
        });

        buttonValidDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonValidDate.setText("Validate Current Date");
        buttonValidDate.setToolTipText("Updates the internal database for use in the exported excel sheet. Only validates sessions with the same starting date as the currently selected date");
        buttonValidDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValidDateActionPerformed(evt);
            }
        });

        buttonRemoveDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonRemoveDate.setText("Remove All in Date");
        buttonRemoveDate.setToolTipText("only clears the view. validate list in order to complete purge.");
        buttonRemoveDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(buttonAddSession, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonValidDate, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel21)
                    .addComponent(buttonRemoveDate, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calendarSessions, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAddSession)
                    .addComponent(buttonValidDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRemoveDate)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calendarSessions, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setText("Activities on:");

        labelDate.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        labelDate.setText("MM/DD/YYYY");

        panelSchedView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelSchedView.setLayout(new javax.swing.BoxLayout(panelSchedView, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane11.setViewportView(panelSchedView);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(labelDate, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
                    .addComponent(jScrollPane11))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Calendar View", jPanel20);

        tableSchedList.setAutoCreateRowSorter(true);
        tableSchedList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Session", "Credential", "Instructor", "StartDate", "EndDate", "Location", "Attendants", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSchedList.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane10.setViewportView(tableSchedList);
        if (tableSchedList.getColumnModel().getColumnCount() > 0) {
            tableSchedList.getColumnModel().getColumn(0).setResizable(false);
            tableSchedList.getColumnModel().getColumn(0).setPreferredWidth(250);
            tableSchedList.getColumnModel().getColumn(1).setResizable(false);
            tableSchedList.getColumnModel().getColumn(1).setPreferredWidth(250);
            tableSchedList.getColumnModel().getColumn(2).setResizable(false);
            tableSchedList.getColumnModel().getColumn(2).setPreferredWidth(250);
            tableSchedList.getColumnModel().getColumn(3).setResizable(false);
            tableSchedList.getColumnModel().getColumn(3).setPreferredWidth(150);
            tableSchedList.getColumnModel().getColumn(4).setResizable(false);
            tableSchedList.getColumnModel().getColumn(4).setPreferredWidth(150);
            tableSchedList.getColumnModel().getColumn(5).setResizable(false);
            tableSchedList.getColumnModel().getColumn(5).setPreferredWidth(250);
            tableSchedList.getColumnModel().getColumn(6).setResizable(false);
            tableSchedList.getColumnModel().getColumn(6).setPreferredWidth(100);
            tableSchedList.getColumnModel().getColumn(7).setResizable(false);
            tableSchedList.getColumnModel().getColumn(7).setPreferredWidth(100);
        }

        jPanel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setText("Session Stats");

        jLabel48.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel48.setText("Total Sessions:");

        jLabel49.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel49.setText("Ongoing Sessions:");

        jLabel50.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel50.setText("Completed Sessions:");

        jButton9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton9.setText("Update Stats");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        labelSessionTotal2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelSessionTotal2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelSessionTotal2.setText("0");

        labelSessionComplete2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelSessionComplete2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelSessionComplete2.setText("0");

        labelSessionOngoing2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelSessionOngoing2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelSessionOngoing2.setText("0");

        jLabel51.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel51.setText("Completion Rate:");

        labelSessionRate2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelSessionRate2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelSessionRate2.setText("0%");

        jLabel52.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel52.setText("Total Attendants:");

        labelSessionAttend2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelSessionAttend2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelSessionAttend2.setText("0");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
                            .addComponent(jLabel50)
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel52)
                            .addComponent(jLabel48))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelSessionAttend2)
                                .addComponent(labelSessionTotal2)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelSessionOngoing2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelSessionComplete2)))
                            .addComponent(labelSessionRate2))))
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(labelSessionTotal2)
                        .addGap(18, 18, 18)
                        .addComponent(labelSessionComplete2)
                        .addGap(18, 18, 18)
                        .addComponent(labelSessionOngoing2)
                        .addGap(53, 53, 53)
                        .addComponent(labelSessionAttend2))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(labelSessionRate2)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel48)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel50)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel49)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel51)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel52)))
                .addContainerGap(217, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane3.addTab("List View", jPanel22);

        buttonSchedSort.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonSchedSort.setText("Sort by:");
        buttonSchedSort.setToolTipText("List must be Validated before performing.");
        buttonSchedSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSchedSortActionPerformed(evt);
            }
        });

        comboSchedFilter.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboSchedFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Session Name", "Credential Name", "Instructor", "Start Date", "End Date", "Location", "Status" }));

        buttonSchedFilter.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonSchedFilter.setText("Search by:");
        buttonSchedFilter.setToolTipText("List must be Validated before performing.");
        buttonSchedFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSchedFilterActionPerformed(evt);
            }
        });

        textFieldSchedFilter.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setText("Schedule Search:");

        buttonSchedFilterReset.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonSchedFilterReset.setText("View All");
        buttonSchedFilterReset.setToolTipText("Resets search and sort view to view list when it was last validated.");
        buttonSchedFilterReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSchedFilterResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane3)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldSchedFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonSchedFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSchedSort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboSchedFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSchedFilterReset)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(textFieldSchedFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSchedFilter)
                    .addComponent(buttonSchedSort)
                    .addComponent(buttonSchedFilterReset)
                    .addComponent(comboSchedFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Scheduler", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelCurrentTab)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonImportAll, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelCurrentDesc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonImport, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonExport, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(buttonExportAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelCurrentTab)
                    .addComponent(buttonExportAll)
                    .addComponent(buttonImportAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(labelCurrentDesc))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonExport)
                        .addComponent(buttonImport)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Save warning when trying to close program
        int confirmexit = JOptionPane.showConfirmDialog(null, "Unsaved progress will be lost. Close program?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (confirmexit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void buttonImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImportActionPerformed
        // TODO add your handling code here:
        if (jTabbedPane1.getSelectedIndex() == 1 || jTabbedPane1.getSelectedIndex() == 2 || jTabbedPane1.getSelectedIndex() == 3 || jTabbedPane1.getSelectedIndex() == 4) {
            int confirm = JOptionPane.showConfirmDialog(null, "This will overwrite currently loaded data on this tab. Continue?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                int offsetRow = 0;
                int offsetCol = 0;
                int defaultRow = 0;
                int defaultCol = 0;
                String sheetName = "";

                PanelOffset offset = new PanelOffset();
                switch (jTabbedPane1.getSelectedIndex()) {
                    case 1 -> { 
                        offset.textName.setText("Students");
                    }
                    case 2 -> { 
                        offset.textName.setText("Departments");
                    }
                    case 3 -> { 
                        offset.textName.setText("Microcredentials");
                    }
                    case 4 -> { 
                        offset.textName.setText("Schedule");
                    }
                }
                //JOptionPane.showConfirmDialog(rootPane, offset, sheetName, offsetCol, offsetCol, icon)
                int set = JOptionPane.showConfirmDialog(null, offset, "Importing Data", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (set == JOptionPane.OK_OPTION) {
                    offsetRow = Integer.parseInt(String.valueOf(offset.spinnerRow.getValue()));
                    offsetCol = Integer.parseInt(String.valueOf(offset.spinnerCol.getValue()));
                    sheetName = offset.textName.getText();

                    JnaFileChooser ch=new JnaFileChooser();
                    boolean action = ch.showOpenDialog(this);
                    if (action) {
                        if (ch.getSelectedFile().isFile() && ch.getSelectedFile().getAbsolutePath().endsWith(".xlsx")) {
                            DefaultTableModel model = (DefaultTableModel) studentValid.getModel();
                            DefaultTableModel head = (DefaultTableModel) tableStudents.getModel();
                            DefaultTableModel model2 = (DefaultTableModel) enrollValid.getModel();
                            DefaultTableModel head2 = (DefaultTableModel) tableEnrolls.getModel();
                            switch (jTabbedPane1.getSelectedIndex()) {
                                case 1 -> { 
                                    model = (DefaultTableModel) studentValid.getModel();
                                    head = (DefaultTableModel) tableStudents.getModel();
                                    model.setRowCount(0);
                                    model.setColumnCount(8);
                                    head.setRowCount(0);
                                    defaultRow = 3;
                                    defaultCol = 1;
                                }
                                case 2 -> { 
                                    model = (DefaultTableModel) deptValid.getModel();
                                    head = (DefaultTableModel) tableDepts.getModel();
                                    model.setRowCount(0);
                                    model.setColumnCount(5);
                                    head.setRowCount(0);
                                    defaultRow = 3;
                                    defaultCol = 1;
                                }
                                case 3 -> { 
                                    model = (DefaultTableModel) credValid.getModel();
                                    head = (DefaultTableModel) tableCreds.getModel();
                                    model2 = (DefaultTableModel) enrollValid.getModel();
                                    head2 = (DefaultTableModel) tableEnrolls.getModel();
                                    model.setRowCount(0);
                                    model.setColumnCount(8);
                                    head.setRowCount(0);
                                    model2.setRowCount(0);
                                    model2.setColumnCount(7);
                                    head2.setRowCount(0);
                                    defaultRow = 3;
                                    defaultCol = 1;
                                }
                                case 4 -> { 
                                    model = (DefaultTableModel) schedValid.getModel();
                                    head = (DefaultTableModel) tableSchedList.getModel();
                                    model.setRowCount(0);
                                    model.setColumnCount(17);
                                    head.setRowCount(0);
                                    //head.setColumnCount(8);
                                    defaultRow = 3;
                                    defaultCol = 1;
                                }
                            }
                            
                            try (FileInputStream file = new FileInputStream(ch.getSelectedFile().getAbsolutePath())) {
                                Workbook workbook = new XSSFWorkbook(file);
                                Sheet sheet = workbook.getSheet(sheetName);
                                Sheet sheet2 = workbook.getSheet("Enrollees");
                                
                                Row row = sheet.getRow(defaultRow + offsetRow);
                                Cell cell = row.getCell(defaultCol + offsetCol);
                                int total = 0;
                                int allEmpty = 0;
                                // check how many cells to go through
                                do {
                                    allEmpty = 0;
                                    if (row == null || row.getPhysicalNumberOfCells() <= 0 || row.getRowNum() <= 0) {
                                        System.out.println("FINAL ROW REACHED");
                                        break;
                                    }
                                    for (int i = 0; i < model.getColumnCount(); i++) {
                                        cell = row.getCell(i + defaultCol + offsetCol);
                                        if (!String.valueOf(cell.toString()).isBlank()) {
                                            allEmpty += 1;
                                            System.out.print(cell.toString() + " ");
                                        }
                                    }
                                    if (allEmpty > 0) {
                                        total += 1;
                                    }
                                    row = sheet.getRow((total + defaultRow + offsetRow));
                                    System.out.println(total);
                                } while (allEmpty > 0);
                                
                                row = sheet.getRow(defaultRow + offsetRow);
                                
                                // iterate through to import the values
                                for (int i = 0; i < total; i++) {
                                    Object[] rowDataA = new Object[model.getColumnCount()];
                                    for (int j = 0; j < model.getColumnCount(); j++) {
                                        cell = row.getCell(j + defaultCol + offsetCol);
                                        rowDataA[j] = cell.toString();
                                        if (jTabbedPane1.getSelectedIndex() == 3) {
                                            
                                        }
                                        if (jTabbedPane1.getSelectedIndex() == 4) {
                                            if (j == 3 || j == 4) {
                                                SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
                                                try {
                                                    Date datestring = sdf.parse(cell.toString());
                                                    rowDataA[j] = datestring;
                                                } catch (ParseException ex) {
                                                    System.getLogger(MainFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                                                }
                                            }
                                            if (j == 7) {
                                                
                                            }
                                            if (j >= 10) {
                                                if (String.valueOf(cell.toString()).equalsIgnoreCase("true")) {
                                                    rowDataA[j] = (boolean) true;
                                                }
                                                if (String.valueOf(cell.toString()).equalsIgnoreCase("false")) {
                                                    rowDataA[j] = (boolean) false;
                                                }
                                            }
                                        }
                                        System.out.print(cell.toString() + " ");
                                    }
                                    System.out.println(Arrays.toString(rowDataA));
                                    model.addRow(rowDataA);
                                    System.out.println();
                                    row = sheet.getRow((i + defaultRow + offsetRow + 1));
                                }
                                
                                row = sheet.getRow(defaultRow + offsetRow);
                                
                                for (int i = 0; i < total; i++) {
                                    Object[] rowDataB = new Object[head.getColumnCount()];
                                    for (int j = 0; j < head.getColumnCount(); j++) {
                                        if (jTabbedPane1.getSelectedIndex() == 3 && j > 2) {
                                            cell = row.getCell(j + 1 + defaultCol + offsetCol);
                                        } else {
                                            cell = row.getCell(j + defaultCol + offsetCol);
                                        }
                                        rowDataB[j] = cell.toString();
                                    }
                                    head.addRow(rowDataB);
                                    System.out.println(Arrays.toString(rowDataB));
                                    row = sheet.getRow((i + defaultRow + offsetRow + 1));
                                }
                                
                                if (jTabbedPane1.getSelectedIndex() == 3) {
                                    row = sheet2.getRow(defaultRow + offsetRow);
                                    cell = row.getCell(defaultCol + offsetCol);
                                    total = 0;
                                    do {
                                        allEmpty = 0;
                                        if (row == null || row.getPhysicalNumberOfCells() <= 0 || row.getRowNum() <= 0) {
                                            System.out.println("FINAL ROW REACHED");
                                            break;
                                        }
                                        for (int i = 0; i < model2.getColumnCount(); i++) {
                                            cell = row.getCell(i + defaultCol + offsetCol);
                                            if (!String.valueOf(cell.toString()).isBlank()) {
                                                allEmpty += 1;
                                                System.out.print(cell.toString() + " ");
                                            }
                                        }
                                        if (allEmpty > 0) {
                                            total += 1;
                                        }
                                        row = sheet2.getRow((total + defaultRow + offsetRow));
                                        System.out.println(total);
                                    } while (allEmpty > 0);
                                    
                                    row = sheet2.getRow(defaultRow + offsetRow);
                                    
                                    for (int i = 0; i < total; i++) {
                                    Object[] rowDataA = new Object[model2.getColumnCount()];
                                        for (int j = 0; j < model2.getColumnCount(); j++) {
                                            cell = row.getCell(j + defaultCol + offsetCol);
                                            rowDataA[j] = cell.toString();
                                        }
                                    model2.addRow(rowDataA);
                                    row = sheet2.getRow((i + defaultRow + offsetRow + 1));
                                    }

                                    row = sheet2.getRow(defaultRow + offsetRow);
                                    for (int i = 0; i < total; i++) {
                                        Object[] rowDataB = new Object[head2.getColumnCount()];
                                        for (int j = 0; j < head2.getColumnCount(); j++) {
                                            cell = row.getCell(j + defaultCol + offsetCol);
                                            rowDataB[j] = cell.toString();
                                        }
                                        head2.addRow(rowDataB);
                                        System.out.println();
                                        row = sheet2.getRow((i + defaultRow + offsetRow + 1));
                                    }
                                }
                                
                                /*PanelSched sched = new PanelSched();
                                sched.textAreaName.setText(String.valueOf(model.getValueAt(0, 0)));
                                panelSchedView.add(sched);
                                panelSchedView.revalidate();
                                panelSchedView.repaint();*/
                                
                                JOptionPane.showMessageDialog(null, "Data Successfully Imported!\nIf data does not show, click 'View All' button.");
                                textAreaLoaded.setText("latest loaded file:\n" + ch.getSelectedFile().getName());
                            } catch (IOException ex) {
                                System.getLogger(MainFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid File Selected!");
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No Data can be imported to the selected tab!");
        }
    }//GEN-LAST:event_buttonImportActionPerformed

    private void buttonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExportActionPerformed
        // TODO add your handling code here:
        if (jTabbedPane1.getSelectedIndex() == 1 || jTabbedPane1.getSelectedIndex() == 2 || jTabbedPane1.getSelectedIndex() == 3 || jTabbedPane1.getSelectedIndex() == 4) {
            int offsetRow = 0;
            int offsetCol = 0;
            int defaultRow = 0;
            int defaultCol = 0;
            String sheetName = "";
            String template = "Master Info.xlsx";
            
            PanelOffset offset = new PanelOffset();
            switch (jTabbedPane1.getSelectedIndex()) {
                case 1 -> { 
                    offset.textName.setText("Students");
                }
                case 2 -> { 
                    offset.textName.setText("Departments");
                }
                case 3 -> { 
                    offset.textName.setText("Microcredentials");
                }
                case 4 -> { 
                    offset.textName.setText("Schedule");
                }
            }
            //JOptionPane.showConfirmDialog(rootPane, offset, sheetName, offsetCol, offsetCol, icon)
            int set = JOptionPane.showConfirmDialog(null, offset, "Exporting Data", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (set == JOptionPane.OK_OPTION) {
                offsetRow = Integer.parseInt(String.valueOf(offset.spinnerRow.getValue()));
                offsetCol = Integer.parseInt(String.valueOf(offset.spinnerCol.getValue()));
                sheetName = offset.textName.getText();
                
                JnaFileChooser ch=new JnaFileChooser();
                boolean action = ch.showSaveDialog(this);
                String load = ch.getSelectedFile().getAbsolutePath();
                if (!load.endsWith(".xlsx")) { load += ".xlsx"; }
                if (action) {
                    boolean confirm = true;
                    boolean merge = false;
                    if (ch.getSelectedFile().isFile()) {
                        int overwrite = JOptionPane.showConfirmDialog(null, "File already exists!\nAs long as offset and sheet names don't overlap, values can be merged.\nThis may overwrite existing data.\nAre you sure?", null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (overwrite == JOptionPane.YES_OPTION) {
                            merge = true;
                        }
                        if (overwrite == JOptionPane.NO_OPTION) {
                            confirm = false;
                        }
                    }
                    if (confirm) {
                        DefaultTableModel model = (DefaultTableModel) studentValid.getModel();
                        DefaultTableModel head = (DefaultTableModel) tableStudents.getModel();
                        DefaultTableModel model2 = (DefaultTableModel) enrollValid.getModel();
                        DefaultTableModel head2 = (DefaultTableModel) tableEnrolls.getModel();
                        switch (jTabbedPane1.getSelectedIndex()) {
                            case 1 -> { 
                                model = (DefaultTableModel) studentValid.getModel();
                                head = (DefaultTableModel) tableStudents.getModel();
                                if (merge) {
                                    template = load;
                                }
                                defaultRow = 3;
                                defaultCol = 0;
                            }
                            case 2 -> { 
                                model = (DefaultTableModel) deptValid.getModel();
                                head = (DefaultTableModel) tableDepts.getModel();
                                if (merge) {
                                    template = load;
                                }
                                defaultRow = 3;
                                defaultCol = 0;
                            }
                            case 3 -> { 
                                model = (DefaultTableModel) credValid.getModel();
                                head = (DefaultTableModel) tableCreds.getModel();
                                model2 = (DefaultTableModel) enrollValid.getModel();
                                head2 = (DefaultTableModel) tableEnrolls.getModel();
                                if (merge) {
                                    template = load;
                                }
                                defaultRow = 3;
                                defaultCol = 0;
                            }
                            case 4 -> { 
                                model = (DefaultTableModel) schedValid.getModel();
                                head = (DefaultTableModel) tableSchedList.getModel();
                                if (merge) {
                                    template = load;
                                }
                                defaultRow = 3;
                                defaultCol = 0;
                            }
                        }
                        try (FileInputStream os = new FileInputStream(template)) {
                            //File dir = new File("Students.xlsx");
                            Workbook wb = WorkbookFactory.create(os);//new XSSFWorkbook(dir.getAbsolutePath()); //Excell workbook
                            
                            //Sheet sheet = wb.createSheet(sheetName); //WorkSheet
                            Sheet sheet;
                            if (wb.getSheetIndex(sheetName) >= 0) {
                                sheet = wb.getSheet(sheetName);
                            } else {
                                sheet = wb.createSheet(sheetName);
                            }
                            //temp = sheet.getRow(2).getRowStyle();
                            Row row = sheet.createRow(defaultRow + offsetRow); //Row created at line 3
                            CellStyle style = wb.createCellStyle();
                            Font font = wb.createFont();  
                            font.setFontHeightInPoints((short)12);  
                            font.setFontName("Century Gothic");
                            style.setFont(font);
                            style.setAlignment(HorizontalAlignment.LEFT);
                            style.setVerticalAlignment(VerticalAlignment.TOP);
                            style.setBorderBottom(BorderStyle.THIN);
                            style.setBorderTop(BorderStyle.THIN);
                            style.setBorderLeft(BorderStyle.THIN);
                            style.setBorderRight(BorderStyle.THIN);
                            CellStyle sch = wb.createCellStyle();
                            sch.setFont(font);
                            sch.setAlignment(HorizontalAlignment.LEFT);
                            sch.setVerticalAlignment(VerticalAlignment.TOP);
                            sch.setBorderBottom(BorderStyle.THIN);
                            sch.setBorderTop(BorderStyle.THIN);
                            sch.setBorderLeft(BorderStyle.THIN);
                            sch.setBorderRight(BorderStyle.THIN);

                            if (jTabbedPane1.getSelectedIndex() == 4) {
                                for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
                                    for(int cols = 0; cols < model.getColumnCount()+1; cols++){ //For each table column
                                        if (cols == 0) {
                                            row.getCell(cols + defaultCol + offsetCol, CREATE_NULL_AS_BLANK).setCellValue(offsetRow+rows+1);
                                        } else if (cols == 4 || cols == 5) {
                                            /*SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
                                            try {
                                                Date datestring = sdf.parse(model.getValueAt(rows, cols-1).toString());
                                                row.getCell(cols + defaultCol + offsetCol, CREATE_NULL_AS_BLANK).setCellValue(datestring);
                                            } catch (ParseException ex) {
                                                System.getLogger(MainFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                                            }*/
                                            Date date = (Date) model.getValueAt(rows, cols-1);
                                            Calendar cal = Calendar.getInstance();
                                            cal.setTime(date);
                                            int monthnum = cal.get(Calendar.MONTH);
                                            int day = cal.get(Calendar.DATE);
                                            int year = cal.get(Calendar.YEAR);
                                            String month = "";
                                            switch (monthnum) {
                                                case 0 -> month = "January";
                                                case 1 -> month = "February";
                                                case 2 -> month = "March";
                                                case 3 -> month = "April";
                                                case 4 -> month = "May";
                                                case 5 -> month = "June";
                                                case 6 -> month = "July";
                                                case 7 -> month = "August";
                                                case 8 -> month = "September";
                                                case 9 -> month = "October";
                                                case 10 -> month = "November";
                                                case 11 -> month = "December";
                                            }
                                            String datestring = month + " " + day + ", " + year;
                                            row.getCell(cols + defaultCol + offsetCol, CREATE_NULL_AS_BLANK).setCellValue(datestring);
                                            row.getCell(cols + defaultCol + offsetCol).setCellStyle(sch);
                                        } else if (cols >= 11) {
                                            row.getCell(cols + defaultCol + offsetCol, CREATE_NULL_AS_BLANK).setCellValue((boolean) model.getValueAt(rows, cols-1));
                                            row.getCell(cols + defaultCol + offsetCol).setCellStyle(sch);
                                        } else {
                                            row.getCell(cols + defaultCol + offsetCol, CREATE_NULL_AS_BLANK).setCellValue(model.getValueAt(rows, cols-1).toString());
                                            row.getCell(cols + defaultCol + offsetCol).setCellStyle(sch);
                                        }
                                        row.setHeightInPoints((short) 30.0);
                                        row.getCell(cols + defaultCol + offsetCol).setCellStyle(style);
                                    }
                                    //Set the row to the next one in the sequence 
                                    row = sheet.getRow((rows + defaultRow + 1 + offsetRow));
                                }
                            } else if (jTabbedPane1.getSelectedIndex() == 3) {
                                for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
                                    for(int cols = 0; cols < model.getColumnCount()+1; cols++){ //For each table column
                                        if (cols == 0) {
                                            row.createCell(cols + defaultCol + offsetCol).setCellValue(offsetRow+rows+1);
                                        } else {
                                            row.createCell(cols + defaultCol + offsetCol).setCellValue(model.getValueAt(rows, cols-1).toString());
                                        }
                                        row.getCell(cols + defaultCol + offsetCol).setCellStyle(style);
                                        row.setHeightInPoints((short) 30.0);
                                    }
                                    //Set the row to the next one in the sequence 
                                    row = sheet.createRow((rows + defaultRow + 1 + offsetRow));
                                }
                                
                                /*if (wb.getSheet("Enrollees") != null) {
                                    sheet = wb.getSheet("Enrollees");
                                } else {
                                    sheet = wb.createSheet("Enrollees");
                                }*/
                                for (int i = 0; i < model2.getRowCount(); i++) {
                                    for (int j = 0; j < model2.getColumnCount(); j++) {
                                        System.out.print(model2.getValueAt(i, j) + ", ");
                                    }
                                    System.out.println("");
                                }
                                Sheet sheet2 = wb.getSheet("Enrollees");
                                row = sheet2.createRow(defaultRow + offsetRow); //Row created at line 3
                                
                                for(int rows = 0; rows < model2.getRowCount(); rows++){ //For each table row
                                    for(int cols = 0; cols < model2.getColumnCount()+1; cols++){ //For each table column
                                        if (cols == 0) {
                                            row.createCell(cols + defaultCol + offsetCol).setCellValue(offsetRow+rows+1);
                                        } else {
                                            row.createCell(cols + defaultCol + offsetCol).setCellValue(model2.getValueAt(rows, cols-1).toString());
                                        }
                                        row.getCell(cols + defaultCol + offsetCol).setCellStyle(style);
                                    }
                                    //Set the row to the next one in the sequence 
                                    row = sheet2.createRow((rows + defaultRow + 1 + offsetRow));
                                }
                            } else {
                                for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
                                    for(int cols = 0; cols < model.getColumnCount()+1; cols++){ //For each table column
                                        if (cols == 0) {
                                            row.createCell(cols + defaultCol + offsetCol).setCellValue(offsetRow+rows+1);
                                        } else {
                                            row.createCell(cols + defaultCol + offsetCol).setCellValue(model.getValueAt(rows, cols-1).toString());
                                        }
                                        row.getCell(cols + defaultCol + offsetCol).setCellStyle(style);
                                    }
                                    //Set the row to the next one in the sequence 
                                    row = sheet.createRow((rows + defaultRow + 1 + offsetRow));
                                }
                            }
                            
                            try (OutputStream out = new FileOutputStream(load)) {
                                wb.write(out);
                                JOptionPane.showMessageDialog(null, "File Successfully Created!");
                            } catch (IOException ex) {
                                System.getLogger(MainFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                            }
                            
                            //wb.write(os);
                            //wb.close();
                            //os.close();
                            //JOptionPane.showMessageDialog(null, "File Successfully Created!");
                        } catch (IOException ex) {
                            System.getLogger(MainFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                        }
                        
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No Data can be extracted in the selected tab!");
        }
    }//GEN-LAST:event_buttonExportActionPerformed

    private void buttonImportAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImportAllActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null, "This will overwrite all currently loaded data. Continue?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            int offsetRow = 0;
            int offsetCol = 0;
            int defaultRow = 0;
            int defaultCol = 0;
            int repeat = 1;
            String sheetName = "";

            //JOptionPane.showConfirmDialog(rootPane, offset, sheetName, offsetCol, offsetCol, icon)
            JnaFileChooser ch=new JnaFileChooser();
            boolean action = ch.showOpenDialog(this);
            if (action) {
                if (ch.getSelectedFile().isFile() && ch.getSelectedFile().getAbsolutePath().endsWith(".xlsx")) {
                    DefaultTableModel model = (DefaultTableModel) studentValid.getModel();
                    DefaultTableModel head = (DefaultTableModel) tableStudents.getModel();
                    DefaultTableModel model2 = (DefaultTableModel) enrollValid.getModel();
                    DefaultTableModel head2 = (DefaultTableModel) tableEnrolls.getModel();
                    while (repeat <= 4) {
                        switch (repeat) {
                        case 1 -> { 
                            sheetName = "Students";
                            model = (DefaultTableModel) studentValid.getModel();
                            head = (DefaultTableModel) tableStudents.getModel();
                            model.setRowCount(0);
                            model.setColumnCount(8);
                            head.setRowCount(0);
                            defaultRow = 3;
                            defaultCol = 1;
                        }
                        case 2 -> { 
                            sheetName = "Departments";
                            model = (DefaultTableModel) deptValid.getModel();
                            head = (DefaultTableModel) tableDepts.getModel();
                            model.setRowCount(0);
                            model.setColumnCount(5);
                            head.setRowCount(0);
                            defaultRow = 3;
                            defaultCol = 1;
                        }
                        case 3 -> { 
                            sheetName = "Microcredentials";
                            model = (DefaultTableModel) credValid.getModel();
                            head = (DefaultTableModel) tableCreds.getModel();
                            model2 = (DefaultTableModel) enrollValid.getModel();
                            head2 = (DefaultTableModel) tableEnrolls.getModel();
                            model.setRowCount(0);
                            model.setColumnCount(8);
                            head.setRowCount(0);
                            model2.setRowCount(0);
                            model2.setColumnCount(7);
                            head2.setRowCount(0);
                            defaultRow = 3;
                            defaultCol = 1;
                        }
                        case 4 -> { 
                            sheetName = "Schedule";
                            model = (DefaultTableModel) schedValid.getModel();
                            head = (DefaultTableModel) tableSchedList.getModel();
                            model.setRowCount(0);
                            model.setColumnCount(17);
                            head.setRowCount(0);
                            //head.setColumnCount(8);
                            defaultRow = 3;
                            defaultCol = 1;
                        }
                    }

                    try (FileInputStream file = new FileInputStream(ch.getSelectedFile().getAbsolutePath())) {
                        Workbook workbook = new XSSFWorkbook(file);
                        Sheet sheet = workbook.getSheet(sheetName);
                        Sheet sheet2 = workbook.getSheet("Enrollees");

                        Row row = sheet.getRow(defaultRow + offsetRow);
                        Cell cell = row.getCell(defaultCol + offsetCol);
                        int total = 0;
                        int allEmpty = 0;
                        // check how many cells to go through
                        do {
                            allEmpty = 0;
                            if (row == null || row.getPhysicalNumberOfCells() <= 0 || row.getRowNum() <= 0) {
                                System.out.println("FINAL ROW REACHED");
                                break;
                            }
                            for (int i = 0; i < model.getColumnCount(); i++) {
                                cell = row.getCell(i + defaultCol + offsetCol);
                                if (!String.valueOf(cell.toString()).isBlank()) {
                                    allEmpty += 1;
                                    System.out.print(cell.toString() + " ");
                                }
                            }
                            if (allEmpty > 0) {
                                total += 1;
                            }
                            row = sheet.getRow((total + defaultRow + offsetRow));
                            System.out.println(total);
                        } while (allEmpty > 0);

                        row = sheet.getRow(defaultRow + offsetRow);

                        // iterate through to import the values
                        for (int i = 0; i < total; i++) {
                            Object[] rowDataA = new Object[model.getColumnCount()];
                            for (int j = 0; j < model.getColumnCount(); j++) {
                                cell = row.getCell(j + defaultCol + offsetCol);
                                rowDataA[j] = cell.toString();
                                if (repeat == 3) {

                                }
                                if (repeat == 4) {
                                    if (j == 3 || j == 4) {
                                        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
                                        try {
                                            Date datestring = sdf.parse(cell.toString());
                                            rowDataA[j] = datestring;
                                        } catch (ParseException ex) {
                                            System.getLogger(MainFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                                        }
                                    }
                                    if (j == 7) {

                                    }
                                    if (j >= 10) {
                                        if (String.valueOf(cell.toString()).equalsIgnoreCase("true")) {
                                            rowDataA[j] = (boolean) true;
                                        }
                                        if (String.valueOf(cell.toString()).equalsIgnoreCase("false")) {
                                            rowDataA[j] = (boolean) false;
                                        }
                                    }
                                }
                                System.out.print(cell.toString() + " ");
                            }
                            System.out.println(Arrays.toString(rowDataA));
                            model.addRow(rowDataA);
                            System.out.println();
                            row = sheet.getRow((i + defaultRow + offsetRow + 1));
                        }

                        row = sheet.getRow(defaultRow + offsetRow);

                        for (int i = 0; i < total; i++) {
                            Object[] rowDataB = new Object[head.getColumnCount()];
                            for (int j = 0; j < head.getColumnCount(); j++) {
                                if (repeat == 3 && j > 2) {
                                    cell = row.getCell(j + 1 + defaultCol + offsetCol);
                                } else {
                                    cell = row.getCell(j + defaultCol + offsetCol);
                                }
                                rowDataB[j] = cell.toString();
                            }
                            head.addRow(rowDataB);
                            System.out.println(Arrays.toString(rowDataB));
                            row = sheet.getRow((i + defaultRow + offsetRow + 1));
                        }

                        if (repeat == 3) {
                            row = sheet2.getRow(defaultRow + offsetRow);
                            cell = row.getCell(defaultCol + offsetCol);
                            total = 0;
                            do {
                                allEmpty = 0;
                                if (row == null || row.getPhysicalNumberOfCells() <= 0 || row.getRowNum() <= 0) {
                                    System.out.println("FINAL ROW REACHED");
                                    break;
                                }
                                for (int i = 0; i < model2.getColumnCount(); i++) {
                                    cell = row.getCell(i + defaultCol + offsetCol);
                                    if (!String.valueOf(cell.toString()).isBlank()) {
                                        allEmpty += 1;
                                        System.out.print(cell.toString() + " ");
                                    }
                                }
                                if (allEmpty > 0) {
                                    total += 1;
                                }
                                row = sheet2.getRow((total + defaultRow + offsetRow));
                                System.out.println(total);
                            } while (allEmpty > 0);

                            row = sheet2.getRow(defaultRow + offsetRow);

                            for (int i = 0; i < total; i++) {
                            Object[] rowDataA = new Object[model2.getColumnCount()];
                                for (int j = 0; j < model2.getColumnCount(); j++) {
                                    cell = row.getCell(j + defaultCol + offsetCol);
                                    rowDataA[j] = cell.toString();
                                }
                            model2.addRow(rowDataA);
                            row = sheet2.getRow((i + defaultRow + offsetRow + 1));
                            }

                            row = sheet2.getRow(defaultRow + offsetRow);
                            for (int i = 0; i < total; i++) {
                                Object[] rowDataB = new Object[head2.getColumnCount()];
                                for (int j = 0; j < head2.getColumnCount(); j++) {
                                    cell = row.getCell(j + defaultCol + offsetCol);
                                    rowDataB[j] = cell.toString();
                                }
                                head2.addRow(rowDataB);
                                System.out.println();
                                row = sheet2.getRow((i + defaultRow + offsetRow + 1));
                            }
                        }
                        if (repeat == 4) {
                            JOptionPane.showMessageDialog(null, "Data Successfully Imported!\nIf data does not show, click 'View All' button.");
                            textAreaLoaded.setText("latest loaded file:\n" + ch.getSelectedFile().getName());
                        }
                    } catch (IOException ex) {
                        System.getLogger(MainFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                        
                        repeat += 1;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid File Selected!");
                }
            }
        }
    }//GEN-LAST:event_buttonImportAllActionPerformed

    private void buttonExportAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExportAllActionPerformed
        // TODO add your handling code here:
        int offsetRow = 0;
        int offsetCol = 0;
        int defaultRow = 0;
        int defaultCol = 0;
        int repeat = 1;
        String sheetName = "";
        String template = "Master Info.xlsx";

        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showSaveDialog(this);
        String load = ch.getSelectedFile().getAbsolutePath();
        if (!load.endsWith(".xlsx")) { load += ".xlsx"; }
        if (action) {
            boolean confirm = true;
            boolean merge = false;
            if (ch.getSelectedFile().isFile()) {
                int overwrite = JOptionPane.showConfirmDialog(null, "File already exists!\nAs long as offset and sheet names don't overlap, values can be merged.\nThis may overwrite existing data.\nAre you sure?", null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (overwrite == JOptionPane.YES_OPTION) {
                    merge = true;
                }
                if (overwrite == JOptionPane.NO_OPTION) {
                    confirm = false;
                }
            }
            if (confirm) {
                DefaultTableModel model = (DefaultTableModel) studentValid.getModel();
                DefaultTableModel head = (DefaultTableModel) tableStudents.getModel();
                DefaultTableModel model2 = (DefaultTableModel) enrollValid.getModel();
                DefaultTableModel head2 = (DefaultTableModel) tableEnrolls.getModel();
                while (repeat <= 4) {
                    switch (repeat) {
                        case 1 -> { 
                            sheetName = "Students";
                            model = (DefaultTableModel) studentValid.getModel();
                            head = (DefaultTableModel) tableStudents.getModel();
                            if (merge) {
                                template = load;
                            }
                            defaultRow = 3;
                            defaultCol = 0;
                        }
                        case 2 -> { 
                            sheetName = "Departments";
                            model = (DefaultTableModel) deptValid.getModel();
                            head = (DefaultTableModel) tableDepts.getModel();
                            if (merge) {
                                template = load;
                            }
                            defaultRow = 3;
                            defaultCol = 0;
                        }
                        case 3 -> { 
                            sheetName = "Microcredentials";
                            model = (DefaultTableModel) credValid.getModel();
                            head = (DefaultTableModel) tableCreds.getModel();
                            model2 = (DefaultTableModel) enrollValid.getModel();
                            head2 = (DefaultTableModel) tableEnrolls.getModel();
                            if (merge) {
                                template = load;
                            }
                            defaultRow = 3;
                            defaultCol = 0;
                        }
                        case 4 -> { 
                            sheetName = "Schedule";
                            model = (DefaultTableModel) schedValid.getModel();
                            head = (DefaultTableModel) tableSchedList.getModel();
                            if (merge) {
                                template = load;
                            }
                            defaultRow = 3;
                            defaultCol = 0;
                        }
                    }
                    try (FileInputStream os = new FileInputStream(template)) {
                        //File dir = new File("Students.xlsx");
                        Workbook wb = WorkbookFactory.create(os);//new XSSFWorkbook(dir.getAbsolutePath()); //Excell workbook

                        //Sheet sheet = wb.createSheet(sheetName); //WorkSheet
                        Sheet sheet;
                        if (wb.getSheetIndex(sheetName) >= 0) {
                            sheet = wb.getSheet(sheetName);
                        } else {
                            sheet = wb.createSheet(sheetName);
                        }
                        //temp = sheet.getRow(2).getRowStyle();
                        Row row = sheet.createRow(defaultRow + offsetRow); //Row created at line 3
                        CellStyle style = wb.createCellStyle();
                        Font font = wb.createFont();  
                        font.setFontHeightInPoints((short)12);  
                        font.setFontName("Century Gothic");
                        style.setFont(font);
                        style.setAlignment(HorizontalAlignment.LEFT);
                        style.setVerticalAlignment(VerticalAlignment.TOP);
                        style.setBorderBottom(BorderStyle.THIN);
                        style.setBorderTop(BorderStyle.THIN);
                        style.setBorderLeft(BorderStyle.THIN);
                        style.setBorderRight(BorderStyle.THIN);
                        CellStyle sch = wb.createCellStyle();
                        sch.setFont(font);
                        sch.setAlignment(HorizontalAlignment.LEFT);
                        sch.setVerticalAlignment(VerticalAlignment.TOP);
                        sch.setBorderBottom(BorderStyle.THIN);
                        sch.setBorderTop(BorderStyle.THIN);
                        sch.setBorderLeft(BorderStyle.THIN);
                        sch.setBorderRight(BorderStyle.THIN);

                        if (repeat == 4) {
                            for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
                                for(int cols = 0; cols < model.getColumnCount()+1; cols++){ //For each table column
                                    if (cols == 0) {
                                        row.getCell(cols + defaultCol + offsetCol, CREATE_NULL_AS_BLANK).setCellValue(offsetRow+rows+1);
                                    } else if (cols == 4 || cols == 5) {
                                        Date date = (Date) model.getValueAt(rows, cols-1);
                                        Calendar cal = Calendar.getInstance();
                                        cal.setTime(date);
                                        int monthnum = cal.get(Calendar.MONTH);
                                        int day = cal.get(Calendar.DATE);
                                        int year = cal.get(Calendar.YEAR);
                                        String month = "";
                                        switch (monthnum) {
                                            case 0 -> month = "January";
                                            case 1 -> month = "February";
                                            case 2 -> month = "March";
                                            case 3 -> month = "April";
                                            case 4 -> month = "May";
                                            case 5 -> month = "June";
                                            case 6 -> month = "July";
                                            case 7 -> month = "August";
                                            case 8 -> month = "September";
                                            case 9 -> month = "October";
                                            case 10 -> month = "November";
                                            case 11 -> month = "December";
                                        }
                                        String datestring = month + " " + day + ", " + year;
                                        row.getCell(cols + defaultCol + offsetCol, CREATE_NULL_AS_BLANK).setCellValue(datestring);
                                        row.getCell(cols + defaultCol + offsetCol).setCellStyle(sch);
                                    } else if (cols >= 11) {
                                        row.getCell(cols + defaultCol + offsetCol, CREATE_NULL_AS_BLANK).setCellValue((boolean) model.getValueAt(rows, cols-1));
                                        row.getCell(cols + defaultCol + offsetCol).setCellStyle(sch);
                                    } else {
                                        row.getCell(cols + defaultCol + offsetCol, CREATE_NULL_AS_BLANK).setCellValue(model.getValueAt(rows, cols-1).toString());
                                        row.getCell(cols + defaultCol + offsetCol).setCellStyle(sch);
                                    }
                                    row.setHeightInPoints((short) 30.0);
                                    row.getCell(cols + defaultCol + offsetCol).setCellStyle(style);
                                }
                                //Set the row to the next one in the sequence 
                                row = sheet.getRow((rows + defaultRow + 1 + offsetRow));
                            }
                        } else if (repeat == 3) {
                            for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
                                for(int cols = 0; cols < model.getColumnCount()+1; cols++){ //For each table column
                                    if (cols == 0) {
                                        row.createCell(cols + defaultCol + offsetCol).setCellValue(offsetRow+rows+1);
                                    } else {
                                        row.createCell(cols + defaultCol + offsetCol).setCellValue(model.getValueAt(rows, cols-1).toString());
                                    }
                                    row.getCell(cols + defaultCol + offsetCol).setCellStyle(style);
                                    row.setHeightInPoints((short) 30.0);
                                }
                                //Set the row to the next one in the sequence 
                                row = sheet.createRow((rows + defaultRow + 1 + offsetRow));
                            }

                            for (int i = 0; i < model2.getRowCount(); i++) {
                                for (int j = 0; j < model2.getColumnCount(); j++) {
                                    System.out.print(model2.getValueAt(i, j) + ", ");
                                }
                                System.out.println("");
                            }
                            Sheet sheet2 = wb.getSheet("Enrollees");
                            row = sheet2.createRow(defaultRow + offsetRow); //Row created at line 3

                            for(int rows = 0; rows < model2.getRowCount(); rows++){ //For each table row
                                for(int cols = 0; cols < model2.getColumnCount()+1; cols++){ //For each table column
                                    if (cols == 0) {
                                        row.createCell(cols + defaultCol + offsetCol).setCellValue(offsetRow+rows+1);
                                    } else {
                                        row.createCell(cols + defaultCol + offsetCol).setCellValue(model2.getValueAt(rows, cols-1).toString());
                                    }
                                    row.getCell(cols + defaultCol + offsetCol).setCellStyle(style);
                                }
                                //Set the row to the next one in the sequence 
                                row = sheet2.createRow((rows + defaultRow + 1 + offsetRow));
                            }
                        } else {
                            for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
                                for(int cols = 0; cols < model.getColumnCount()+1; cols++){ //For each table column
                                    if (cols == 0) {
                                        row.createCell(cols + defaultCol + offsetCol).setCellValue(offsetRow+rows+1);
                                    } else {
                                        row.createCell(cols + defaultCol + offsetCol).setCellValue(model.getValueAt(rows, cols-1).toString());
                                    }
                                    row.getCell(cols + defaultCol + offsetCol).setCellStyle(style);
                                }
                                //Set the row to the next one in the sequence 
                                row = sheet.createRow((rows + defaultRow + 1 + offsetRow));
                            }
                        }

                        try (OutputStream out = new FileOutputStream(load)) {
                            wb.write(out);
                            if (repeat == 4) {
                                JOptionPane.showMessageDialog(null, "File Successfully Created!");
                            }
                        } catch (IOException ex) {
                            System.getLogger(MainFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                        }
                    } catch (IOException ex) {
                        System.getLogger(MainFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                    
                    repeat += 1;
                    template = load;
                }
            }
        }
    }//GEN-LAST:event_buttonExportAllActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FrameInstructions instruct = new FrameInstructions();
        instruct.setLocationRelativeTo(null);
        instruct.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // Changes Title and Description Texts on the top of window when changing tabs
        tabindex = jTabbedPane1.getSelectedIndex();

        switch (tabindex) {
            case 0:
            labelCurrentTab.setText("Dashboard");
            labelCurrentDesc.setText("General Overview of the Database");
            break;
            case 1:
            labelCurrentTab.setText("Student Manager");
            labelCurrentDesc.setText("Manage Student Records and Enrollment Information");
            break;
            case 2:
            labelCurrentTab.setText("Department Manager");
            labelCurrentDesc.setText("Manage Academic Departments and their Information");
            break;
            case 3:
            labelCurrentTab.setText("Microcredentials Manager");
            labelCurrentDesc.setText("Manage Microcredentials and Enroll Students to them");
            break;
            case 4:
            labelCurrentTab.setText("Training Schedule");
            labelCurrentDesc.setText("Manage the Schedule of Programs and Training Sessions");
            break;
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void buttonSchedFilterResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSchedFilterResetActionPerformed
        // TODO add your handling code here:

        panelSchedView.removeAll();

        // USE MODEL & TABLE TO DRAW NEW PANELS

        DefaultTableModel schedmodel = (DefaultTableModel) schedValid.getModel();
        // DefaultTableModel schedlist = (DefaultTableModel) tableSchedList.getModel();
        for (int i = 0; i < schedmodel.getRowCount(); i++) {
            for (int j = 0; j < schedmodel.getColumnCount(); j++) {
                System.out.print("[" + schedmodel.getValueAt(i, j) + "], " + schedmodel.getValueAt(i, j).getClass());
            }
            System.out.println("");
        }

        System.out.println(schedmodel.getRowCount());
        if (schedmodel.getRowCount() > 0) {
            for (int i = 0; i < schedmodel.getRowCount(); i++) {
                //System.out.println(schedmodel.getValueAt(i, 3).getClass().getTypeName());
                if(calendarSessions.getDate().compareTo((Date) schedmodel.getValueAt(i, 3)) >= 0 && calendarSessions.getDate().compareTo((Date) schedmodel.getValueAt(i, 4)) <= 0) {
                    PanelSched sched = new PanelSched();
                    sched.enrollList = enrollValid;
                    sched.textAreaName.setText(String.valueOf(schedmodel.getValueAt(i, 0)));
                    sched.textAreaDesc.setText(String.valueOf(schedmodel.getValueAt(i, 8)));
                    sched.textFieldInst.setText(String.valueOf(schedmodel.getValueAt(i, 2)));
                    sched.textFieldMicrocred.setText(String.valueOf(schedmodel.getValueAt(i, 1)));
                    sched.textFieldLocation.setText(String.valueOf(schedmodel.getValueAt(i, 5)));
                    sched.labelCapacity.setText(String.valueOf(schedmodel.getValueAt(i, 6)));
                    sched.comboStatus.setSelectedItem(schedmodel.getValueAt(i, 7));
                    sched.textFieldTime.setText(String.valueOf(schedmodel.getValueAt(i, 9)));
                    sched.dateStart.setDate((Date) (schedmodel.getValueAt(i, 3)));
                    sched.dateEnd.setDate((Date) (schedmodel.getValueAt(i, 4)));
                    sched.checkMon.setSelected((boolean) schedmodel.getValueAt(i, 10));
                    sched.checkTue.setSelected((boolean) schedmodel.getValueAt(i, 11));
                    sched.checkWed.setSelected((boolean) schedmodel.getValueAt(i, 12));
                    sched.checkThu.setSelected((boolean) schedmodel.getValueAt(i, 13));
                    sched.checkFri.setSelected((boolean) schedmodel.getValueAt(i, 14));
                    sched.checkSat.setSelected((boolean) schedmodel.getValueAt(i, 15));
                    sched.checkSun.setSelected((boolean) schedmodel.getValueAt(i, 16));
                    sched.getStudentList();
                    panelSchedView.add(sched);
                    System.out.println("panel created");
                }
            }
        }

        panelSchedView.revalidate();
        panelSchedView.repaint();
    }//GEN-LAST:event_buttonSchedFilterResetActionPerformed

    private void buttonSchedFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSchedFilterActionPerformed
        // TODO add your handling code here:

        panelSchedView.removeAll();

        // USE MODEL & TABLE TO DRAW NEW PANELS

        DefaultTableModel schedmodel = (DefaultTableModel) schedValid.getModel();
        // DefaultTableModel schedlist = (DefaultTableModel) tableSchedList.getModel();

        int action = comboSchedFilter.getSelectedIndex();
        String filter = textFieldSchedFilter.getText();
        String search = "";

        if (schedmodel.getRowCount() > 0) {
            for (int i = 0; i < schedmodel.getRowCount(); i++) {
                //System.out.println(schedmodel.getValueAt(i, 3).getClass().getTypeName());
                switch (action) {
                    case 0 -> search = String.valueOf(schedmodel.getValueAt(i, 0));
                    case 1 -> search = String.valueOf(schedmodel.getValueAt(i, 1));
                    case 2 -> search = String.valueOf(schedmodel.getValueAt(i, 2));
                    case 3 -> search = String.valueOf(schedmodel.getValueAt(i, 3));
                    case 4 -> search = String.valueOf(schedmodel.getValueAt(i, 4));
                    case 5 -> search = String.valueOf(schedmodel.getValueAt(i, 5));
                    case 6 -> search = String.valueOf(schedmodel.getValueAt(i, 7));
                }
                if (search.toLowerCase().contains(filter.toLowerCase())) {
                    if(calendarSessions.getDate().compareTo((Date) schedmodel.getValueAt(i, 3)) >= 0 && calendarSessions.getDate().compareTo((Date) schedmodel.getValueAt(i, 4)) <= 0) {
                        PanelSched sched = new PanelSched();
                        sched.enrollList = enrollValid;
                        sched.textAreaName.setText(String.valueOf(schedmodel.getValueAt(i, 0)));
                        sched.textAreaDesc.setText(String.valueOf(schedmodel.getValueAt(i, 8)));
                        sched.textFieldInst.setText(String.valueOf(schedmodel.getValueAt(i, 2)));
                        sched.textFieldMicrocred.setText(String.valueOf(schedmodel.getValueAt(i, 1)));
                        sched.textFieldLocation.setText(String.valueOf(schedmodel.getValueAt(i, 5)));
                        sched.labelCapacity.setText(String.valueOf(schedmodel.getValueAt(i, 6)));
                        sched.comboStatus.setSelectedItem(schedmodel.getValueAt(i, 7));
                        sched.textFieldTime.setText(String.valueOf(schedmodel.getValueAt(i, 9)));
                        sched.dateStart.setDate((Date) (schedmodel.getValueAt(i, 3)));
                        sched.dateEnd.setDate((Date) (schedmodel.getValueAt(i, 4)));
                        sched.checkMon.setSelected((boolean) schedmodel.getValueAt(i, 10));
                        sched.checkTue.setSelected((boolean) schedmodel.getValueAt(i, 11));
                        sched.checkWed.setSelected((boolean) schedmodel.getValueAt(i, 12));
                        sched.checkThu.setSelected((boolean) schedmodel.getValueAt(i, 13));
                        sched.checkFri.setSelected((boolean) schedmodel.getValueAt(i, 14));
                        sched.checkSat.setSelected((boolean) schedmodel.getValueAt(i, 15));
                        sched.checkSun.setSelected((boolean) schedmodel.getValueAt(i, 16));
                        sched.getStudentList();
                        panelSchedView.add(sched);
                    }
                }
            }
        }

        panelSchedView.revalidate();
        panelSchedView.repaint();
    }//GEN-LAST:event_buttonSchedFilterActionPerformed

    private void buttonSchedSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSchedSortActionPerformed
        // TODO add your handling code here:

        // USE MODEL & TABLE TO DRAW NEW PANELS

        DefaultTableModel schedmodel = (DefaultTableModel) schedValid.getModel();
        DefaultTableModel schedlist = (DefaultTableModel) tableSchedList.getModel();

        int action = comboSchedFilter.getSelectedIndex();
        int select = 0;
        int counter = 0;
        int pointer;
        int dest = schedmodel.getRowCount();
        int dest2 = schedmodel.getRowCount();

        String arrsortsched[][] = new String[schedmodel.getRowCount()][schedmodel.getColumnCount()];
        String arrsortlist[][] = new String[schedlist.getRowCount()][schedlist.getColumnCount()];
        Date arrsortdate[][] = new Date[schedmodel.getRowCount()][2];

        for (int i = 0; i < arrsortsched.length; i++) {
            for (int j = 0; j < arrsortsched[i].length; j++) {
                arrsortsched[i][j] = String.valueOf(schedmodel.getValueAt(i, j));
                System.out.print(arrsortsched[i][j] + ", ");
            }
            System.out.println("");
        }

        System.out.println(schedlist.getRowCount());
        System.out.println(schedlist.getColumnCount());
        System.out.println(arrsortlist.length);
        System.out.println(arrsortlist[0].length);
        for (int i = 0; i < arrsortlist.length; i++) {
            for (int j = 0; j < arrsortlist[i].length; j++) {
                arrsortlist[i][j] = String.valueOf(schedlist.getValueAt(i, j));
            }
        }

        switch (action) {
            case 0 -> { // session name
                sortbyColumn(arrsortsched, 0);
                sortbyColumn(arrsortlist, 0);
                select = 0;
            }
            case 1 -> { // cred name
                sortbyColumn(arrsortsched, 1);
                sortbyColumn(arrsortlist, 1);
                select = 1;
            }
            case 2 -> { // instructor
                sortbyColumn(arrsortsched, 2);
                sortbyColumn(arrsortlist, 2);
                select = 2;
            }
            case 3 -> { // start date
                sortbyColumn(arrsortlist, 3);
                SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
                for (int i = 0; i < arrsortlist.length; i++) {
                    try {
                        arrsortdate[i][0] = sdf.parse(arrsortlist[i][3]);
                        System.out.println(arrsortdate[i][0]);
                    } catch (ParseException ex) {
                        System.getLogger(MainFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                }
                sortbyDate(arrsortdate, 0);
                select = 3;
            }
            case 4 -> { // end date
                sortbyColumn(arrsortlist, 4);
                SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
                for (int i = 0; i < arrsortlist.length; i++) {
                    try {
                        arrsortdate[i][0] = sdf.parse(arrsortlist[i][4]);
                        System.out.println(arrsortdate[i][0]);
                    } catch (ParseException ex) {
                        System.getLogger(MainFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                }
                sortbyDate(arrsortdate, 0);
                select = 4;
            }
            case 5 -> { // location
                sortbyColumn(arrsortsched, 5);
                sortbyColumn(arrsortlist, 5);
                select = 5;
            }
            case 6 -> { // status
                sortbyColumn(arrsortsched, 7);
                sortbyColumn(arrsortlist, 7);
                select = 7;
            }
        }

        System.out.println("=======================================");

        for (int i = 0; i < arrsortsched.length; i++) {
            for (int j = 0; j < arrsortsched[i].length; j++) {
                System.out.print(arrsortsched[i][j] + ", ");
            }
            System.out.println("");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        Date[][] d = new Date[arrsortsched.length][2];

        try {
            for (int i = 0; i < arrsortsched.length; i++) {
                d[i][0] = sdf.parse(arrsortsched[i][3]);
                d[i][1] = sdf.parse(arrsortsched[i][4]);
                System.out.println(d[i][1]);
                System.out.println(schedmodel.getValueAt(i, 4));
                System.out.println(d[i][1].toString().equals(schedmodel.getValueAt(i, 4).toString()));
            }
        } catch (ParseException ex) {
            System.getLogger(MainFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        if (select == 3) {
            sortbyDate(d, 0);
            for (int i = 0; i < d.length; i++) {
                System.out.println(d[i][0]);
            }
        }
        if (select == 4) {
            sortbyDate(d, 1);
            for (int i = 0; i < d.length; i++) {
                System.out.println(d[i][1]);
            }
        }

        while (counter < dest) {
            pointer = counter;
            for (int i = 0; i < schedmodel.getRowCount(); i++) {
                if (select == 3) {
                    if (d[pointer][0].toString().equals(schedmodel.getValueAt(i, 3).toString())) {
                        schedmodel.moveRow(i, i, dest-1);
                        System.out.println("true");
                        break;
                    }
                    System.out.println("false");
                } else if (select == 4) {
                    if (d[pointer][1].toString().equals(schedmodel.getValueAt(i, 4).toString())) {
                        schedmodel.moveRow(i, i, dest-1);
                        System.out.println("true");
                        break;
                    }
                    System.out.println("false");
                } else if (schedmodel.getValueAt(i, select) == arrsortsched[pointer][select]) {
                    schedmodel.moveRow(i, i, dest-1);
                    System.out.println("true");
                    break;
                }
                System.out.println("false");
            }
            counter += 1;
        }

        counter = 0;
        while (counter < dest2) {
            pointer = counter;
            for (int i = 0; i < schedlist.getRowCount(); i++) {
                if (schedlist.getValueAt(i, select) == arrsortlist[pointer][select]) {
                    schedlist.moveRow(i, i, dest-1);
                    break;
                }
            }
            counter += 1;
        }

        for (int i = 0; i < schedmodel.getRowCount(); i++) {
            for (int j = 0; j < schedmodel.getColumnCount(); j++) {
                System.out.print(schedmodel.getValueAt(i, j) + ", ");
            }
            System.out.println("");
        }

        panelSchedView.removeAll();

        if (schedmodel.getRowCount() > 0) {
            for (int i = 0; i < schedmodel.getRowCount(); i++) {
                //System.out.println(schedmodel.getValueAt(i, 3).getClass().getTypeName());
                if(calendarSessions.getDate().compareTo((Date) schedmodel.getValueAt(i, 3)) >= 0 && calendarSessions.getDate().compareTo((Date) schedmodel.getValueAt(i, 4)) <= 0) {
                    PanelSched sched = new PanelSched();
                    sched.enrollList = enrollValid;
                    sched.textAreaName.setText(String.valueOf(schedmodel.getValueAt(i, 0)));
                    sched.textAreaDesc.setText(String.valueOf(schedmodel.getValueAt(i, 8)));
                    sched.textFieldInst.setText(String.valueOf(schedmodel.getValueAt(i, 2)));
                    sched.textFieldMicrocred.setText(String.valueOf(schedmodel.getValueAt(i, 1)));
                    sched.textFieldLocation.setText(String.valueOf(schedmodel.getValueAt(i, 5)));
                    sched.labelCapacity.setText(String.valueOf(schedmodel.getValueAt(i, 6)));
                    sched.comboStatus.setSelectedItem(schedmodel.getValueAt(i, 7));
                    sched.textFieldTime.setText(String.valueOf(schedmodel.getValueAt(i, 9)));
                    sched.dateStart.setDate((Date) (schedmodel.getValueAt(i, 3)));
                    sched.dateEnd.setDate((Date) (schedmodel.getValueAt(i, 4)));
                    sched.checkMon.setSelected((boolean) schedmodel.getValueAt(i, 10));
                    sched.checkTue.setSelected((boolean) schedmodel.getValueAt(i, 11));
                    sched.checkWed.setSelected((boolean) schedmodel.getValueAt(i, 12));
                    sched.checkThu.setSelected((boolean) schedmodel.getValueAt(i, 13));
                    sched.checkFri.setSelected((boolean) schedmodel.getValueAt(i, 14));
                    sched.checkSat.setSelected((boolean) schedmodel.getValueAt(i, 15));
                    sched.checkSun.setSelected((boolean) schedmodel.getValueAt(i, 16));
                    sched.getStudentList();
                    panelSchedView.add(sched);
                }
            }
        }

        panelSchedView.revalidate();
        panelSchedView.repaint();

        // TO DO HERE:
        // - MOVE SORTED ROWS BACK UP SO THEY'RE PROPERLY POSITIONED ALONGSIDE THE REST OF THE SCHEDULES IN LIST VIEW
        // - UPDATE LIST VIEW IN ACCORDANCE TO THE PROPERLY SORTED ROW (MOVE IT UP AS WELL)
    }//GEN-LAST:event_buttonSchedSortActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableSchedList.getModel();
        int sessions = tableSchedList.getRowCount();
        int ongoing = 0;
        int complete = 0;
        int attend = 0;
        double rate = 0;

        for (int i = 0; i < model.getRowCount(); i++) {
            if (String.valueOf(model.getValueAt(i, 7)).equalsIgnoreCase("complete")) { complete += 1; }
            attend += Integer.parseInt(String.valueOf(model.getValueAt(i, 6)));
        }
        ongoing = sessions - complete;
        rate = (double) ((double)complete/(double)sessions)*100;
        labelSessionTotal2.setText(String.valueOf(sessions));
        labelSessionComplete2.setText(String.valueOf(complete));
        labelSessionOngoing2.setText(String.valueOf(ongoing));
        labelSessionRate2.setText(String.format("%.0f", rate) + "%");
        labelSessionAttend2.setText(String.valueOf(attend));
    }//GEN-LAST:event_jButton9ActionPerformed

    private void buttonRemoveDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveDateActionPerformed
        // TODO add your handling code here:
        panelSchedView.removeAll();
        panelSchedView.revalidate();
        panelSchedView.repaint();
    }//GEN-LAST:event_buttonRemoveDateActionPerformed

    private void buttonValidDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValidDateActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) schedValid.getModel();
        DefaultTableModel table = (DefaultTableModel) tableSchedList.getModel();
        int toval = panelSchedView.getComponentCount();
        model.setColumnCount(17);

        if (toval > 0) {
            int confirmvalid = JOptionPane.showConfirmDialog(null, "This will overwrite current validated list with the current one\nand affects multiple lists. Are you sure?\n(Will only validate sessions with same start date as current selected date.)","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (confirmvalid == JOptionPane.YES_OPTION) {

                // MAKE CODE THAT GOES THROUGH SCHEDVALID TABLE AND DELETES ALL ROWS WITH SAME START DATE AS CURRENT DATE

                if (model.getRowCount() > 0 && table.getRowCount() > 0) {
                    int mrows = model.getRowCount();
                    for (int i = mrows-1; i >= 0; i--) {
                        if (calendarSessions.getDate().compareTo((Date) model.getValueAt(i, 3)) == 0) {
                            model.removeRow(i);
                            table.removeRow(i);
                        }
                    }
                }

                for (int i = 0; i < toval; i++) {
                    PanelSched schedpan = (PanelSched) panelSchedView.getComponent(i);

                    String startday = String.valueOf(schedpan.dateStart.getCalendar().get(Calendar.DATE));
                    String startyear = String.valueOf(schedpan.dateStart.getCalendar().get(Calendar.YEAR));
                    int startmonthnum = schedpan.dateStart.getCalendar().get(Calendar.MONTH);
                    String startmonth = "";
                    switch (startmonthnum) {
                        case 0 -> startmonth = "January";
                        case 1 -> startmonth = "February";
                        case 2 -> startmonth = "March";
                        case 3 -> startmonth = "April";
                        case 4 -> startmonth = "May";
                        case 5 -> startmonth = "June";
                        case 6 -> startmonth = "July";
                        case 7 -> startmonth = "August";
                        case 8 -> startmonth = "September";
                        case 9 -> startmonth = "October";
                        case 10 -> startmonth = "November";
                        case 11 -> startmonth = "December";
                    }
                    String startdate = startmonth + " " + startday + ", " + startyear;

                    String endday = String.valueOf(schedpan.dateEnd.getCalendar().get(Calendar.DATE));
                    String endyear = String.valueOf(schedpan.dateEnd.getCalendar().get(Calendar.YEAR));
                    int endmonthnum = schedpan.dateEnd.getCalendar().get(Calendar.MONTH);
                    String endmonth = "";
                    switch (endmonthnum) {
                        case 0 -> endmonth = "January";
                        case 1 -> endmonth = "February";
                        case 2 -> endmonth = "March";
                        case 3 -> endmonth = "April";
                        case 4 -> endmonth = "May";
                        case 5 -> endmonth = "June";
                        case 6 -> endmonth = "July";
                        case 7 -> endmonth = "August";
                        case 8 -> endmonth = "September";
                        case 9 -> endmonth = "October";
                        case 10 -> endmonth = "November";
                        case 11 -> endmonth = "December";
                    }
                    String enddate = endmonth + " " + endday + ", " + endyear;

                    schedpan.getStudentList();

                    System.out.println(calendarSessions.getDate().compareTo(schedpan.dateStart.getDate()));

                    if (calendarSessions.getDate().compareTo(schedpan.dateStart.getDate()) == 0) {
                        model.addRow(new Object[]{ schedpan.textAreaName.getText(), schedpan.textFieldMicrocred.getText(), schedpan.textFieldInst.getText(), schedpan.dateStart.getDate(), schedpan.dateEnd.getDate(), schedpan.textFieldLocation.getText(), schedpan.labelCapacity.getText(), schedpan.comboStatus.getSelectedItem(), schedpan.textAreaDesc.getText(), schedpan.textFieldTime.getText(), schedpan.checkMon.isSelected(), schedpan.checkTue.isSelected(), schedpan.checkWed.isSelected(), schedpan.checkThu.isSelected(), schedpan.checkFri.isSelected(), schedpan.checkSat.isSelected(), schedpan.checkSun.isSelected() });
                        table.addRow(new Object[]{ schedpan.textAreaName.getText(), schedpan.textFieldMicrocred.getText(), schedpan.textFieldInst.getText(), startdate, enddate, schedpan.textFieldLocation.getText(), schedpan.labelCapacity.getText(), schedpan.comboStatus.getSelectedItem() });
                    }
                }
                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        System.out.print(model.getValueAt(i, j) + ", ");
                    }
                    System.out.println("");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No sessions to process!");
        }
    }//GEN-LAST:event_buttonValidDateActionPerformed

    private void buttonAddSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddSessionActionPerformed
        // TODO add your handling code here:
        //DefaultTableModel totransfer = (DefaultTableModel) enrollValid.getModel();
        //JTable transfer = new JTable(validList);
        //transfer.setModel(totransfer);

        Calendar cal = Calendar.getInstance();

        cal.setTime(calendarSessions.getDate());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        PanelSched sched = new PanelSched();
        sched.enrollList = enrollValid;
        sched.dateStart.setDate(calendarSessions.getDate());
        sched.dateStart.setCalendar(cal);
        sched.dateEnd.setDate(calendarSessions.getDate());
        sched.dateEnd.setCalendar(cal);
        panelSchedView.add(sched);
        panelSchedView.revalidate();
        panelSchedView.repaint();
    }//GEN-LAST:event_buttonAddSessionActionPerformed

    private void calendarSessionsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarSessionsPropertyChange
        // TODO add your handling code here:
        String day = String.valueOf(calendarSessions.getDayChooser().getDay());
        String year = String.valueOf(calendarSessions.getYearChooser().getYear());
        int monthnum = calendarSessions.getMonthChooser().getMonth();
        String month = "";
        switch (monthnum) {
            case 0 -> month = "January";
            case 1 -> month = "February";
            case 2 -> month = "March";
            case 3 -> month = "April";
            case 4 -> month = "May";
            case 5 -> month = "June";
            case 6 -> month = "July";
            case 7 -> month = "August";
            case 8 -> month = "September";
            case 9 -> month = "October";
            case 10 -> month = "November";
            case 11 -> month = "December";
        }
        labelDate.setText(month + " " + day + ", " + year);

        Calendar cal = Calendar.getInstance();

        cal.setTime(calendarSessions.getDate());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        calendarSessions.setCalendar(cal);

        System.out.println(calendarSessions.getDate());

        panelSchedView.removeAll();

        // USE MODEL & TABLE TO DRAW NEW PANELS

        DefaultTableModel schedmodel = (DefaultTableModel) schedValid.getModel();
        // DefaultTableModel schedlist = (DefaultTableModel) tableSchedList.getModel();

        if (schedmodel.getRowCount() > 0) {
            for (int i = 0; i < schedmodel.getRowCount(); i++) {
                //System.out.println(schedmodel.getValueAt(i, 3).getClass().getTypeName());
                if(calendarSessions.getDate().compareTo((Date) schedmodel.getValueAt(i, 3)) >= 0 && calendarSessions.getDate().compareTo((Date) schedmodel.getValueAt(i, 4)) <= 0) {
                    PanelSched sched = new PanelSched();
                    sched.enrollList = enrollValid;
                    sched.textAreaName.setText(String.valueOf(schedmodel.getValueAt(i, 0)));
                    sched.textAreaDesc.setText(String.valueOf(schedmodel.getValueAt(i, 8)));
                    sched.textFieldInst.setText(String.valueOf(schedmodel.getValueAt(i, 2)));
                    sched.textFieldMicrocred.setText(String.valueOf(schedmodel.getValueAt(i, 1)));
                    sched.textFieldLocation.setText(String.valueOf(schedmodel.getValueAt(i, 5)));
                    sched.labelCapacity.setText(String.valueOf(schedmodel.getValueAt(i, 6)));
                    sched.comboStatus.setSelectedItem(schedmodel.getValueAt(i, 7));
                    sched.textFieldTime.setText(String.valueOf(schedmodel.getValueAt(i, 9)));
                    sched.dateStart.setDate((Date) (schedmodel.getValueAt(i, 3)));
                    sched.dateEnd.setDate((Date) (schedmodel.getValueAt(i, 4)));
                    sched.checkMon.setSelected((boolean) schedmodel.getValueAt(i, 10));
                    sched.checkTue.setSelected((boolean) schedmodel.getValueAt(i, 11));
                    sched.checkWed.setSelected((boolean) schedmodel.getValueAt(i, 12));
                    sched.checkThu.setSelected((boolean) schedmodel.getValueAt(i, 13));
                    sched.checkFri.setSelected((boolean) schedmodel.getValueAt(i, 14));
                    sched.checkSat.setSelected((boolean) schedmodel.getValueAt(i, 15));
                    sched.checkSun.setSelected((boolean) schedmodel.getValueAt(i, 16));
                    sched.getStudentList();
                    panelSchedView.add(sched);
                }
            }
        }

        //System.out.println(calendarSessions.get);

        panelSchedView.revalidate();
        panelSchedView.repaint();
    }//GEN-LAST:event_calendarSessionsPropertyChange

    private void buttonSortCredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSortCredActionPerformed
        // TODO add your handling code here:
        DefaultTableModel sortcreds = (DefaultTableModel) credValid.getModel();
        DefaultTableModel check = (DefaultTableModel) tableCreds.getModel();
        DefaultTableModel sortenroll = (DefaultTableModel) enrollValid.getModel();

        int action = comboFilterCred.getSelectedIndex();

        String arrsortcreds[][] = new String[sortcreds.getRowCount()][sortcreds.getColumnCount()];
        String arrsortcheck[][] = new String[check.getRowCount()][check.getColumnCount()];
        int arrsortint[][] = new int[sortcreds.getRowCount()][3];
        System.out.println("rows: " + arrsortcreds.length);
        System.out.println("columns: " + arrsortcreds[0].length);

        System.out.println("ARRSORTCREDS");
        for (int i = 0; i < arrsortcreds.length; i++) {
            for (int j = 0; j < arrsortcreds[i].length; j++) {
                arrsortcreds[i][j] = String.valueOf(sortcreds.getValueAt(i, j));
                System.out.print(arrsortcreds[i][j]);
                System.out.print(", ");
            }
            System.out.println("");
        }
        System.out.println("ARRSORTCHECK");
        for (int i = 0; i < arrsortcheck.length; i++) {
            for (int j = 0; j < arrsortcheck[i].length; j++) {
                arrsortcheck[i][j] = String.valueOf(check.getValueAt(i, j));
                System.out.print(arrsortcreds[i][j]);
                System.out.print(", ");
            }
            System.out.println("");
        }

        switch (action) {
            case 0 -> {
                // code
                sortbyColumn(arrsortcreds, 0);
                sortbyColumn(arrsortcheck, 0);
            }
            case 1 -> {
                // name
                sortbyColumn(arrsortcreds, 1);
                sortbyColumn(arrsortcheck, 1);
            }
            case 2 -> {
                // dept
                sortbyColumn(arrsortcreds, 2);
                sortbyColumn(arrsortcheck, 2);
            }
            case 3 -> {
                // duration
                System.out.println("ARRSORTINT");
                for (int i = 0; i < arrsortcreds.length; i++) {
                    arrsortint[i][0] = Integer.parseInt(arrsortcreds[i][4]);
                    arrsortint[i][1] = 0;
                    arrsortint[i][2] = 0;
                    System.out.print(arrsortint[i][0] + ", ");
                }
                //sortbyNumber(arrsortint, 0);
            }
            case 4 -> {
                // enrolled
                for (int i = 0; i < arrsortcreds.length; i++) {
                    arrsortint[i][0] = Integer.parseInt(arrsortcreds[i][5]);
                    arrsortint[i][1] = 0;
                    arrsortint[i][2] = 0;
                    System.out.print(arrsortint[i][0] + ", ");
                }
                //sortbyNumber(arrsortint, 0);
            }
            case 5 -> {
                // completed
                sortbyColumn(arrsortcreds, 6);
                sortbyColumn(arrsortcheck, 5);
            }
        }
        int process = 0;
        if (action == 0 || action == 1 || action == 2 || action == 5) {
            for (int i = 0; i < arrsortcreds.length; i++) {
                System.out.println("Row " + i + ": ");
                for (int j = 0; j < arrsortcreds[i].length; j++) {
                    System.out.print(arrsortcreds[i][j]);
                    System.out.print(", ");
                    sortcreds.setValueAt(arrsortcreds[i][j], i, j);
                }
                System.out.println("");
                System.out.println("======================================");
            }
            for (int i = 0; i < arrsortcheck.length; i++) {
                for (int j = 0; j < arrsortcheck[i].length; j++) {
                    check.setValueAt(arrsortcheck[i][j], i, j);
                }
            }
        } else if (action == 3) {
            for (int i = 0; i < arrsortcreds.length; i++) {
                arrsortint[i][0] = Integer.parseInt(arrsortcreds[i][4]);
                arrsortint[i][1] = 0;
                arrsortint[i][2] = 0;
            }
            sortbyNumber(arrsortint, 0);
            sortcreds.setRowCount(0);
            check.setRowCount(0);
            process = 0;
            while (process < arrsortcreds.length) {
                for (int i = 0; i < arrsortcreds.length; i++) {
                    System.out.println(arrsortint[process][0] + " == " + Integer.parseInt(arrsortcreds[i][4]));
                    if (arrsortint[process][0] == Integer.parseInt(arrsortcreds[i][4]) && arrsortint[i][1] == 0) {
                        sortcreds.addRow(new Object[] { arrsortcreds[i][0], arrsortcreds[i][1], arrsortcreds[i][2], arrsortcreds[i][3], arrsortcreds[i][4], arrsortcreds[i][5], arrsortcreds[i][6], arrsortcreds[i][7] });
                        arrsortint[i][1] = 1;
                        process += 1;
                        break;
                    }
                }
            }
            System.out.println("finished");
            process = 0;
            while (process < arrsortcheck.length) {
                for (int i = 0; i < arrsortcheck.length; i++) {
                    System.out.println(arrsortint[process][0] + " == " + Integer.parseInt(arrsortcheck[i][3]));
                    if (arrsortint[process][0] == Integer.parseInt(arrsortcheck[i][3]) && arrsortint[i][2] == 0) {
                        check.addRow(new Object[] { arrsortcheck[i][0], arrsortcheck[i][1], arrsortcheck[i][2], arrsortcheck[i][3], arrsortcheck[i][4], arrsortcheck[i][5] });
                        arrsortint[i][2] = 1;
                        process += 1;
                        break;
                    }
                }
            }
            System.out.println("finished");
        } else if (action == 4) {
            for (int i = 0; i < arrsortcreds.length; i++) {
                arrsortint[i][0] = Integer.parseInt(arrsortcreds[i][5]);
                arrsortint[i][1] = 0;
                arrsortint[i][2] = 0;
            }
            sortbyNumber(arrsortint, 0);
            sortcreds.setRowCount(0);
            check.setRowCount(0);
            process = 0;
            while (process < arrsortcreds.length) {
                for (int i = 0; i < arrsortcreds.length; i++) {
                    System.out.println(arrsortint[process][0] + " == " + Integer.parseInt(arrsortcreds[i][5]));
                    if (arrsortint[process][0] == Integer.parseInt(arrsortcreds[i][5]) && arrsortint[i][1] == 0) {
                        sortcreds.addRow(new Object[] { arrsortcreds[i][0], arrsortcreds[i][1], arrsortcreds[i][2], arrsortcreds[i][3], arrsortcreds[i][4], arrsortcreds[i][5], arrsortcreds[i][6], arrsortcreds[i][7] });
                        arrsortint[i][1] = 1;
                        process += 1;
                        break;
                    }
                }
            }
            System.out.println("finished");
            process = 0;
            while (process < arrsortcheck.length) {
                for (int i = 0; i < arrsortcheck.length; i++) {
                    System.out.println(arrsortint[process][0] + " == " + Integer.parseInt(arrsortcheck[i][4]));
                    if (arrsortint[process][0] == Integer.parseInt(arrsortcheck[i][4]) && arrsortint[i][2] == 0) {
                        check.addRow(new Object[] { arrsortcheck[i][0], arrsortcheck[i][1], arrsortcheck[i][2], arrsortcheck[i][3], arrsortcheck[i][4], arrsortcheck[i][5] });
                        arrsortint[i][2] = 1;
                        process += 1;
                        break;
                    }
                }
            }
            System.out.println("finished");
        }

        panelCredList.removeAll();

        for (int i = 0; i < sortcreds.getRowCount(); i++) {
            PanelCred cred = new PanelCred();
            //DefaultTableModel studs = (DefaultTableModel) cred.enrollMcValid.getModel();
            //DefaultTableModel studtab = (DefaultTableModel) cred.tableCredEnrolls.getModel();
            cred.textAreaName.setText(String.valueOf(sortcreds.getValueAt(i, 1)));
            cred.textAreaCode.setText(String.valueOf(sortcreds.getValueAt(i, 0)));
            cred.textAreaDept.setText(String.valueOf(sortcreds.getValueAt(i, 2)));
            cred.textAreaDesc.setText(String.valueOf(sortcreds.getValueAt(i, 3)));
            cred.textAreaPrereq.setText(String.valueOf(sortcreds.getValueAt(i, 7)));
            String spinner = String.valueOf(sortcreds.getValueAt(i, 4));
            cred.spinnerDuration.setValue(Integer.parseInt(spinner));
            cred.labelEnrollCount.setText(String.valueOf(sortcreds.getValueAt(i, 5)));
            cred.labelCompleteCount.setText(String.valueOf(sortcreds.getValueAt(i, 6)));

            panelCredList.add(cred);
        }

        int enrolllisting = panelCredList.getComponentCount();
        for (int i = 0; i < enrolllisting; i++) {
            PanelCred credpan = (PanelCred) panelCredList.getComponent(i);

            DefaultTableModel studs = (DefaultTableModel) credpan.enrollMcValid.getModel();
            DefaultTableModel studtab = (DefaultTableModel) credpan.tableCredEnrolls.getModel();
            studs.setColumnCount(studtab.getColumnCount());

            for (int j = 0; j < sortenroll.getRowCount(); j++) {
                String studlist = String.valueOf(sortenroll.getValueAt(j, 2));
                if (studlist.equals(credpan.textAreaName.getText())) {
                    studs.addRow(new Object[]{sortenroll.getValueAt(j, 0), sortenroll.getValueAt(j, 1), sortenroll.getValueAt(j, 3), sortenroll.getValueAt(j, 4), sortenroll.getValueAt(j, 5), sortenroll.getValueAt(j, 6)});
                    studtab.addRow(new Object[]{sortenroll.getValueAt(j, 0), sortenroll.getValueAt(j, 1), sortenroll.getValueAt(j, 3), sortenroll.getValueAt(j, 4), sortenroll.getValueAt(j, 5), sortenroll.getValueAt(j, 6)});
                }
            }

            /*double total = Double.parseDouble(credpan.labelEnrollCount.getText());
            double complete = 0;

            for (int k = 0; k < studtab.getRowCount(); k++) {
                if (String.valueOf(studtab.getValueAt(k, 2)).equalsIgnoreCase("complete")) {
                    complete += 1;
                }
            }

            double fin = (complete/total)*100;

            credpan.labelCompleteCount.setText(String.format("%.0f", fin) + "%");*/
        }

        panelCredList.revalidate();
        panelCredList.repaint();
    }//GEN-LAST:event_buttonSortCredActionPerformed

    private void buttonFilterCredResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterCredResetActionPerformed
        // TODO add your handling code here:
        DefaultTableModel filtercreds = (DefaultTableModel) credValid.getModel();
        DefaultTableModel filterenroll = (DefaultTableModel) enrollValid.getModel();
        DefaultTableModel filtertable = (DefaultTableModel) tableCreds.getModel();
        panelCredList.removeAll();

        for (int i = 0; i < filtercreds.getRowCount(); i++) {
            PanelCred cred = new PanelCred();
            //DefaultTableModel studs = (DefaultTableModel) cred.enrollMcValid.getModel();
            //DefaultTableModel studtab = (DefaultTableModel) cred.tableCredEnrolls.getModel();
            cred.textAreaName.setText(String.valueOf(filtercreds.getValueAt(i, 1)));
            cred.textAreaCode.setText(String.valueOf(filtercreds.getValueAt(i, 0)));
            cred.textAreaDept.setText(String.valueOf(filtercreds.getValueAt(i, 2)));
            cred.textAreaDesc.setText(String.valueOf(filtercreds.getValueAt(i, 3)));
            cred.textAreaPrereq.setText(String.valueOf(filtercreds.getValueAt(i, 7)));
            String spinner = String.valueOf(filtercreds.getValueAt(i, 4));
            cred.spinnerDuration.setValue(Integer.parseInt(spinner));
            cred.labelEnrollCount.setText(String.valueOf(filtercreds.getValueAt(i, 5)));
            cred.labelCompleteCount.setText(String.valueOf(filtercreds.getValueAt(i, 6)));

            panelCredList.add(cred);
        }

        int enrolllisting = panelCredList.getComponentCount();
        for (int i = 0; i < enrolllisting; i++) {
            PanelCred credpan = (PanelCred) panelCredList.getComponent(i);

            DefaultTableModel studs = (DefaultTableModel) credpan.enrollMcValid.getModel();
            DefaultTableModel studtab = (DefaultTableModel) credpan.tableCredEnrolls.getModel();
            studs.setColumnCount(studtab.getColumnCount());

            for (int j = 0; j < filterenroll.getRowCount(); j++) {
                String studlist = String.valueOf(filterenroll.getValueAt(j, 2));
                if (studlist.equals(credpan.textAreaName.getText())) {
                    studs.addRow(new Object[]{filterenroll.getValueAt(j, 0), filterenroll.getValueAt(j, 1), filterenroll.getValueAt(j, 3), filterenroll.getValueAt(j, 4), filterenroll.getValueAt(j, 5), filterenroll.getValueAt(j, 6)});
                    studtab.addRow(new Object[]{filterenroll.getValueAt(j, 0), filterenroll.getValueAt(j, 1), filterenroll.getValueAt(j, 3), filterenroll.getValueAt(j, 4), filterenroll.getValueAt(j, 5), filterenroll.getValueAt(j, 6)});
                }
            }

            double total = Double.parseDouble(credpan.labelEnrollCount.getText());
            double complete = 0;

            for (int k = 0; k < studtab.getRowCount(); k++) {
                if (String.valueOf(studtab.getValueAt(k, 2)).toLowerCase().equals("complete")) {
                    complete += 1;
                }
            }

            double fin = (complete/total)*100;

            credpan.labelCompleteCount.setText(String.format("%.0f", fin) + "%");
        }

        filtertable.setRowCount(0);

        for (int i = 0; i < filtercreds.getRowCount(); i++) {
            filtertable.addRow(new Object[]{filtercreds.getValueAt(i, 0), filtercreds.getValueAt(i, 1), filtercreds.getValueAt(i, 2), filtercreds.getValueAt(i, 4), filtercreds.getValueAt(i, 5), filtercreds.getValueAt(i, 6)});
        }

        panelCredList.revalidate();
        panelCredList.repaint();
    }//GEN-LAST:event_buttonFilterCredResetActionPerformed

    private void buttonValAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValAllActionPerformed
        // TODO add your handling code here:
        DefaultTableModel mcvalid = (DefaultTableModel) credValid.getModel();
        DefaultTableModel envalid = (DefaultTableModel) enrollValid.getModel();
        DefaultTableModel creds = (DefaultTableModel) tableCreds.getModel();
        DefaultTableModel enrolls = (DefaultTableModel) tableEnrolls.getModel();
        int toval = panelCredList.getComponentCount();

        if (toval > 0) {
            int confirmvalid = JOptionPane.showConfirmDialog(null, "This will overwrite current validated list with the current one and affects multiple lists. Are you sure?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (confirmvalid == JOptionPane.YES_OPTION) {
                mcvalid.setRowCount(0);
                envalid.setRowCount(0);
                creds.setRowCount(0);
                enrolls.setRowCount(0);
                mcvalid.setColumnCount(8);
                envalid.setColumnCount(7);
                for (int i = 0; i < toval; i++) {
                    PanelCred credpan = (PanelCred) panelCredList.getComponent(i);
                    if ((Integer) credpan.spinnerDuration.getValue() == 0) {
                        credpan.spinnerDuration.setValue(0);
                    }
                    mcvalid.addRow(new Object[]{credpan.textAreaCode.getText(), credpan.textAreaName.getText(), credpan.textAreaDept.getText(), credpan.textAreaDesc.getText(), credpan.spinnerDuration.getValue(), credpan.labelEnrollCount.getText(), credpan.labelCompleteCount.getText(), credpan.textAreaPrereq.getText()});
                    creds.addRow(new Object[]{credpan.textAreaCode.getText(), credpan.textAreaName.getText(), credpan.textAreaDept.getText(), credpan.spinnerDuration.getValue(), credpan.labelEnrollCount.getText(), credpan.labelCompleteCount.getText()});

                    DefaultTableModel model = (DefaultTableModel) credpan.tableCredEnrolls.getModel();
                    DefaultTableModel valid = (DefaultTableModel) credpan.enrollMcValid.getModel();

                    valid.setRowCount(model.getRowCount());
                    valid.setColumnCount(model.getColumnCount());

                    for (int j = 0; j < model.getRowCount(); j++) {
                        for (int k = 0; k < model.getColumnCount(); k++) {
                            valid.setValueAt(model.getValueAt(j, k), j, k);
                        }
                    }

                    credpan.labelEnrollCount.setText(String.valueOf(credpan.tableCredEnrolls.getRowCount()));

                    DefaultTableModel studs = (DefaultTableModel) credpan.enrollMcValid.getModel();
                    for (int l = 0; l < studs.getRowCount(); l++) {
                        if (studs.getValueAt(l, 0) != null || studs.getValueAt(l, 1) != null) {
                            enrolls.addRow(new Object[]{studs.getValueAt(l, 0), studs.getValueAt(l, 1), credpan.textAreaName.getText(), studs.getValueAt(l, 2), studs.getValueAt(l, 3), studs.getValueAt(l, 4), studs.getValueAt(l, 5)});
                            envalid.addRow(new Object[]{studs.getValueAt(l, 0), studs.getValueAt(l, 1), credpan.textAreaName.getText(), studs.getValueAt(l, 2), studs.getValueAt(l, 3), studs.getValueAt(l, 4), studs.getValueAt(l, 5)});
                        }
                    }

                    double total = Double.parseDouble(credpan.labelEnrollCount.getText());
                    double complete = 0;

                    for (int k = 0; k < model.getRowCount(); k++) {
                        if (String.valueOf(model.getValueAt(k, 2)).equalsIgnoreCase("complete")) {
                            complete += 1;
                        }
                    }

                    double fin = (complete/total)*100;

                    credpan.labelCompleteCount.setText(String.format("%.0f", fin) + "%");
                    mcvalid.setValueAt(credpan.labelCompleteCount.getText(), i, 6);
                    mcvalid.setValueAt(credpan.labelEnrollCount.getText(), i, 5);
                    creds.setValueAt(credpan.labelCompleteCount.getText(), i, 5);
                    creds.setValueAt(credpan.labelEnrollCount.getText(), i, 4);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No credentials to process!");
        }
    }//GEN-LAST:event_buttonValAllActionPerformed

    private void buttonDelAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDelAllActionPerformed
        // TODO add your handling code here:
        int confirmvalid = JOptionPane.showConfirmDialog(null, "This will delete all data in Microcredentials. Are you sure?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (confirmvalid == JOptionPane.YES_OPTION) {
            DefaultTableModel mcvalid = (DefaultTableModel) credValid.getModel();
            DefaultTableModel envalid = (DefaultTableModel) enrollValid.getModel();
            DefaultTableModel creds = (DefaultTableModel) tableCreds.getModel();
            DefaultTableModel enrolls = (DefaultTableModel) tableEnrolls.getModel();
            mcvalid.setRowCount(0);
            envalid.setRowCount(0);
            creds.setRowCount(0);
            enrolls.setRowCount(0);
            panelCredList.removeAll();
            panelCredList.revalidate();
            panelCredList.repaint();
        }
    }//GEN-LAST:event_buttonDelAllActionPerformed

    private void buttonFilterCredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterCredActionPerformed
        // TODO add your handling code here:
        DefaultTableModel filtercreds = (DefaultTableModel) credValid.getModel();
        DefaultTableModel filterenroll = (DefaultTableModel) enrollValid.getModel();
        DefaultTableModel filtertable = (DefaultTableModel) tableCreds.getModel();
        panelCredList.removeAll();

        int action = comboFilterCred.getSelectedIndex();

        String filter = textFieldFilterCred.getText();
        for (int i = 0; i < filtercreds.getRowCount(); i++) {
            String search = String.valueOf(filtercreds.getValueAt(i, action));
            if (search.toLowerCase().contains(filter.toLowerCase())) {
                PanelCred cred = new PanelCred();
                //DefaultTableModel studs = (DefaultTableModel) cred.enrollMcValid.getModel();
                //DefaultTableModel studtab = (DefaultTableModel) cred.tableCredEnrolls.getModel();
                cred.textAreaName.setText(String.valueOf(filtercreds.getValueAt(i, 1)));
                cred.textAreaCode.setText(String.valueOf(filtercreds.getValueAt(i, 0)));
                cred.textAreaDept.setText(String.valueOf(filtercreds.getValueAt(i, 2)));
                cred.textAreaDesc.setText(String.valueOf(filtercreds.getValueAt(i, 3)));
                cred.textAreaPrereq.setText(String.valueOf(filtercreds.getValueAt(i, 7)));
                String spinner = String.valueOf(filtercreds.getValueAt(i, 4));
                cred.spinnerDuration.setValue(Integer.parseInt(spinner));
                cred.labelEnrollCount.setText(String.valueOf(filtercreds.getValueAt(i, 5)));
                cred.labelCompleteCount.setText(String.valueOf(filtercreds.getValueAt(i, 6)));

                panelCredList.add(cred);
            }
        }

        int enrolllisting = panelCredList.getComponentCount();
        for (int i = 0; i < enrolllisting; i++) {
            PanelCred credpan = (PanelCred) panelCredList.getComponent(i);

            DefaultTableModel studs = (DefaultTableModel) credpan.enrollMcValid.getModel();
            DefaultTableModel studtab = (DefaultTableModel) credpan.tableCredEnrolls.getModel();
            studs.setColumnCount(studtab.getColumnCount());

            for (int j = 0; j < filterenroll.getRowCount(); j++) {
                String studlist = String.valueOf(filterenroll.getValueAt(j, 2));
                if (studlist.equals(credpan.textAreaName.getText())) {
                    studs.addRow(new Object[]{filterenroll.getValueAt(j, 0), filterenroll.getValueAt(j, 1), filterenroll.getValueAt(j, 3), filterenroll.getValueAt(j, 4), filterenroll.getValueAt(j, 5), filterenroll.getValueAt(j, 6)});
                    studtab.addRow(new Object[]{filterenroll.getValueAt(j, 0), filterenroll.getValueAt(j, 1), filterenroll.getValueAt(j, 3), filterenroll.getValueAt(j, 4), filterenroll.getValueAt(j, 5), filterenroll.getValueAt(j, 6)});
                }
            }

            double total = Double.parseDouble(credpan.labelEnrollCount.getText());
            double complete = 0;

            for (int k = 0; k < studtab.getRowCount(); k++) {
                if (String.valueOf(studtab.getValueAt(k, 2)).toLowerCase().equals("complete")) {
                    complete += 1;
                }
            }

            double fin = (complete/total)*100;

            credpan.labelCompleteCount.setText(String.format("%.0f", fin) + "%");
        }

        filtertable.setRowCount(0);

        for (int i = 0; i < filtercreds.getRowCount(); i++) {
            String search = String.valueOf(filtercreds.getValueAt(i, action));
            if (search.toLowerCase().contains(filter.toLowerCase())) {
                filtertable.addRow(new Object[]{filtercreds.getValueAt(i, 0), filtercreds.getValueAt(i, 1), filtercreds.getValueAt(i, 2), filtercreds.getValueAt(i, 4), filtercreds.getValueAt(i, 5), filtercreds.getValueAt(i, 6)});
            }
        }

        panelCredList.revalidate();
        panelCredList.repaint();
    }//GEN-LAST:event_buttonFilterCredActionPerformed

    private void buttonNewCredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewCredActionPerformed
        // TODO add your handling code here:
        PanelCred cred = new PanelCred();
        //PanelCred.enrollMcValid = enrollValid;
        cred.mainstudstab = tableStudents;
        //cred.
        panelCredList.add(cred);
        panelCredList.revalidate();
        panelCredList.repaint();
    }//GEN-LAST:event_buttonNewCredActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here
        DefaultTableModel model = (DefaultTableModel) tableEnrolls.getModel();
        DefaultTableModel valid = (DefaultTableModel) enrollValid.getModel();

        model.setRowCount(valid.getRowCount());

        for (int i = 0; i < valid.getRowCount(); i++) {
            for (int j = 0; j < valid.getColumnCount()-1; j++) {
                model.setValueAt(valid.getValueAt(i, j), i, j);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void buttonSortEnrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSortEnrollActionPerformed
        // TODO add your handling code here
        DefaultTableModel sortenroll = (DefaultTableModel) enrollValid.getModel();
        DefaultTableModel confirm = (DefaultTableModel) tableEnrolls.getModel();

        String sortarray[][] = new String[sortenroll.getRowCount()][sortenroll.getColumnCount()];
        int sortint[][] = new int[sortenroll.getRowCount()][2];
        Date arrsortdate[][] = new Date[sortenroll.getRowCount()][2];

        for (int i = 0; i < sortarray.length; i++) {
            for (int j = 0; j < sortarray[i].length; j++) {
                if (sortenroll.getValueAt(i, j) != null) {
                    sortarray[i][j] = String.valueOf(sortenroll.getValueAt(i, j));
                } else {
                    sortarray[i][j] = "";
                }
            }
        }

        int process = 0;

        if (comboFilterEnroll.getSelectedIndex() == 6) {
            for (int i = 0; i < sortarray.length; i++) {
                sortint[i][0] = Integer.parseInt(sortarray[i][6]);
                sortint[i][1] = 0;
            }
            sortbyNumber(sortint, 0);
            confirm.setRowCount(0);
            process = sortint.length-1;
            while (process >= 0) {
                for (int i = sortint.length-1; i >= 0; i--) {
                    if (sortint[process][0] == Integer.parseInt(sortarray[i][6]) && sortint[i][1] == 0) {
                        confirm.addRow(new Object[] { sortarray[i][0], sortarray[i][1], sortarray[i][2], sortarray[i][3], sortarray[i][4], sortarray[i][5], sortarray[i][6] });
                        sortint[i][1] = 1;
                        process -= 1;
                        break;
                    }
                }
            }
        } else if (comboFilterEnroll.getSelectedIndex() == 4 || comboFilterEnroll.getSelectedIndex() == 5) {
            SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
            for (int i = 0; i < sortarray.length; i++) {
                try {
                    arrsortdate[i][0] = sdf.parse(sortarray[i][comboFilterEnroll.getSelectedIndex()]);
                    System.out.println(arrsortdate[i][0]);
                } catch (ParseException ex) {
                    System.getLogger(MainFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }
            sortbyDate(arrsortdate, 0);
            confirm.setRowCount(0);
            while (process < arrsortdate.length) {
                for (int i = 0; i < arrsortdate.length; i++) {
                    try {
                        Date getDate = sdf.parse(sortarray[i][comboFilterEnroll.getSelectedIndex()]);
                        if (arrsortdate[process][0].compareTo(getDate) == 0 && arrsortdate[i][1] == null) {
                            confirm.addRow(new Object[] { sortarray[i][0], sortarray[i][1], sortarray[i][2], sortarray[i][3], sortarray[i][4], sortarray[i][5], sortarray[i][6] });
                            arrsortdate[i][1] = getDate;
                            process += 1;
                            break;
                        }
                    } catch (ParseException ex) {
                        System.getLogger(MainFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                }
            }
        } else {
            sortbyColumn(sortarray, comboFilterEnroll.getSelectedIndex());
            confirm.setRowCount(0);
            for (int i = 0; i < sortarray.length; i++) {
                confirm.addRow(new Object[]{ sortarray[i][0], sortarray[i][1], sortarray[i][2], sortarray[i][3], sortarray[i][4], sortarray[i][5], sortarray[i][6] });
            }
        }
    }//GEN-LAST:event_buttonSortEnrollActionPerformed

    private void buttonFilterEnrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterEnrollActionPerformed
        DefaultTableModel model = (DefaultTableModel) tableEnrolls.getModel();
        DefaultTableModel valid = (DefaultTableModel) enrollValid.getModel();

        model.setRowCount(0);

        int action = comboFilterEnroll.getSelectedIndex();

        String filter = textFieldFilterEnroll.getText();
        for (int i = 0; i < valid.getRowCount(); i++) {
            String search = String.valueOf(valid.getValueAt(i, action));
            if (search.toLowerCase().contains(filter.toLowerCase())) {
                model.addRow(new Object[]{valid.getValueAt(i, 0), valid.getValueAt(i, 1), valid.getValueAt(i, 2), valid.getValueAt(i, 3), valid.getValueAt(i, 4), valid.getValueAt(i, 5), valid.getValueAt(i, 6)});
            }
        }
    }//GEN-LAST:event_buttonFilterEnrollActionPerformed

    private void buttonDeptUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeptUpdateActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableDepts.getModel();
        model.setValueAt(textDeptName.getText(), tableDepts.getSelectedRow(), 0);
        model.setValueAt(textDeptHead.getText(), tableDepts.getSelectedRow(), 1);
        model.setValueAt(spinnerDeptStudents.getValue(), tableDepts.getSelectedRow(), 2);
        model.setValueAt(comboDeptStatus.getSelectedItem(), tableDepts.getSelectedRow(), 3);
        model.setValueAt(spinnerDeptDate.getValue(), tableDepts.getSelectedRow(), 4);
    }//GEN-LAST:event_buttonDeptUpdateActionPerformed

    private void buttonAddDeptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddDeptActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableDepts.getModel();
        model.addRow(new Object[]{ textDeptName.getText(), textDeptHead.getText(), spinnerDeptStudents.getValue(), comboDeptStatus.getSelectedItem(), spinnerDeptDate.getValue() });
    }//GEN-LAST:event_buttonAddDeptActionPerformed

    private void buttonDeptRowRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeptRowRemoveActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableDepts.getModel();
        for (int i = 0; i < tableDepts.getSelectedRowCount(); i++) {
            model.removeRow(tableDepts.getSelectedRow() + i);
        }
        model.removeRow(tableDepts.getSelectedRow());
    }//GEN-LAST:event_buttonDeptRowRemoveActionPerformed

    private void buttonDeptSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeptSortActionPerformed
        // TODO add your handling code here:
        DefaultTableModel sortdept = (DefaultTableModel) deptValid.getModel();
        DefaultTableModel confirm = (DefaultTableModel) tableDepts.getModel();

        String sortarray[][] = new String[sortdept.getRowCount()][sortdept.getColumnCount()];
        int sortint[][] = new int[sortdept.getRowCount()][2];

        for (int i = 0; i < sortarray.length; i++) {
            for (int j = 0; j < sortarray[i].length; j++) {
                if (sortdept.getValueAt(i, j) != null) {
                    sortarray[i][j] = String.valueOf(sortdept.getValueAt(i, j));
                } else {
                    sortarray[i][j] = "";
                }
            }
        }
        int process = 0;
        if (comboDeptFilter.getSelectedIndex() == 2) {
            for (int i = 0; i < sortarray.length; i++) {
                sortint[i][0] = Integer.parseInt(sortarray[i][2]);
                sortint[i][1] = 0;
            }
            sortbyNumber(sortint, 0);
            confirm.setRowCount(0);
            process = 0;
            while (process < sortint.length) {
                for (int i = 0; i < sortint.length; i++) {
                    if (sortint[process][0] == Integer.parseInt(sortarray[i][2]) && sortint[i][1] == 0) {
                        confirm.addRow(new Object[] { sortarray[i][0], sortarray[i][1], sortarray[i][2], sortarray[i][3], sortarray[i][4] });
                        sortint[i][1] = 1;
                        process += 1;
                        break;
                    }
                }
            }
        } else if (comboDeptFilter.getSelectedIndex() == 4) {
            for (int i = 0; i < sortarray.length; i++) {
                sortint[i][0] = Integer.parseInt(sortarray[i][4]);
                sortint[i][1] = 0;
            }
            sortbyNumber(sortint, 0);
            confirm.setRowCount(0);
            process = 0;
            while (process < sortint.length) {
                for (int i = 0; i < sortint.length; i++) {
                    if (sortint[process][0] == Integer.parseInt(sortarray[i][4]) && sortint[i][1] == 0) {
                        confirm.addRow(new Object[] { sortarray[i][0], sortarray[i][1], sortarray[i][2], sortarray[i][3], sortarray[i][4] });
                        sortint[i][1] = 1;
                        process += 1;
                        break;
                    }
                }
            }
        } else {
            sortbyColumn(sortarray, comboDeptFilter.getSelectedIndex());
            for (int i = 0; i < sortarray.length; i++) {
                for (int j = 0; j < sortarray[i].length; j++) {
                    // sortstudent.setValueAt(sortarray[i][j], i, j);
                    confirm.setValueAt(sortarray[i][j], i, j);
                }
            }
        }
    }//GEN-LAST:event_buttonDeptSortActionPerformed

    private void buttonDeptFilterResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeptFilterResetActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableDepts.getModel();
        DefaultTableModel valid = (DefaultTableModel) deptValid.getModel();

        model.setRowCount(valid.getRowCount());

        for (int i = 0; i < valid.getRowCount(); i++) {
            for (int j = 0; j < valid.getColumnCount(); j++) {
                model.setValueAt(valid.getValueAt(i, j), i, j);
            }
        }
    }//GEN-LAST:event_buttonDeptFilterResetActionPerformed

    private void buttonDeptValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeptValidateActionPerformed
        // TODO add your handling code here:
        int confirmvalid = JOptionPane.showConfirmDialog(null, "This will overwrite current validated list with the current one. Are you sure?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (confirmvalid == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) tableDepts.getModel();
            DefaultTableModel valid = (DefaultTableModel) deptValid.getModel();

            valid.setRowCount(model.getRowCount());
            valid.setColumnCount(model.getColumnCount());

            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    valid.setValueAt(model.getValueAt(i, j), i, j);
                }
            }
        }
    }//GEN-LAST:event_buttonDeptValidateActionPerformed

    private void buttonDeptDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeptDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableDepts.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_buttonDeptDeleteActionPerformed

    private void buttonDeptRowAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeptRowAddActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableDepts.getModel();
        model.addRow(new Object[]{});
    }//GEN-LAST:event_buttonDeptRowAddActionPerformed

    private void buttonDeptFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeptFilterActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableDepts.getModel();
        DefaultTableModel valid = (DefaultTableModel) deptValid.getModel();

        model.setRowCount(0);

        int action = comboDeptFilter.getSelectedIndex();

        String filter = textFieldDeptFilter.getText();
        for (int i = 0; i < valid.getRowCount(); i++) {
            String search = String.valueOf(valid.getValueAt(i, action));
            if (search.toLowerCase().contains(filter.toLowerCase())) {
                model.addRow(new Object[]{valid.getValueAt(i, 0), valid.getValueAt(i, 1), valid.getValueAt(i, 2), valid.getValueAt(i, 3), valid.getValueAt(i, 4)});
            }
        }
    }//GEN-LAST:event_buttonDeptFilterActionPerformed

    private void comboDeptFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDeptFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDeptFilterActionPerformed

    private void tableDeptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDeptsMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableDepts.getModel();
        if (tableDepts.getSelectedRowCount() > 0 && tableDepts.isFocusOwner()) {
            int selected = tableDepts.getSelectedRow();
            if (model.getValueAt(selected, 0) != null) { textDeptName.setText(String.valueOf(model.getValueAt(selected, 0))); } else { textDeptName.setText(""); }
            if (model.getValueAt(selected, 1) != null) { textDeptHead.setText(String.valueOf(model.getValueAt(selected, 1))); } else { textDeptHead.setText(""); }
            if (model.getValueAt(selected, 2) != null) { spinnerDeptStudents.setValue(Integer.valueOf(model.getValueAt(selected, 2).toString())); } else { spinnerDeptStudents.setValue(0); }
            if (model.getValueAt(selected, 3) != null) {
                String status = String.valueOf(model.getValueAt(selected, 3));
                if (status.equalsIgnoreCase("active")) { comboDeptStatus.setSelectedIndex(0); }
                else if (status.equalsIgnoreCase("inactive")) { comboDeptStatus.setSelectedIndex(1); }
                else { comboDeptStatus.setSelectedIndex(0); }
            } else { comboDeptStatus.setSelectedIndex(0); }
            if (model.getValueAt(selected, 4) != null) { spinnerDeptDate.setValue(Integer.valueOf(model.getValueAt(selected, 4).toString())); } else { spinnerDeptDate.setValue(0); }
        }
    }//GEN-LAST:event_tableDeptsMouseClicked

    private void buttonStudentUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStudentUpdateActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableStudents.getModel();
        model.setValueAt(textStudentNumber.getText(), tableStudents.getSelectedRow(), 0);
        model.setValueAt(textStudentName.getText(), tableStudents.getSelectedRow(), 1);
        model.setValueAt(textStudentEmail.getText(), tableStudents.getSelectedRow(), 2);
        model.setValueAt(textStudentEMailAlt.getText(), tableStudents.getSelectedRow(), 3);
        model.setValueAt(textStudentDept.getText(), tableStudents.getSelectedRow(), 4);
        model.setValueAt(textStudentPhone.getText(), tableStudents.getSelectedRow(), 5);
        model.setValueAt(textStudentFB.getText(), tableStudents.getSelectedRow(), 6);
        model.setValueAt(comboStudentStatus.getSelectedItem(), tableStudents.getSelectedRow(), 7);
    }//GEN-LAST:event_buttonStudentUpdateActionPerformed

    private void buttonAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddStudentActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableStudents.getModel();
        model.addRow(new Object[]{ textStudentNumber.getText(), textStudentName.getText(), textStudentEmail.getText(), textStudentEMailAlt.getText(), textStudentDept.getText(), textStudentPhone.getText(), textStudentFB.getText(), comboStudentStatus.getSelectedItem() });
    }//GEN-LAST:event_buttonAddStudentActionPerformed

    private void buttonStudentRowRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStudentRowRemoveActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableStudents.getModel();
        for (int i = 0; i < tableStudents.getSelectedRowCount(); i++) {
            model.removeRow(tableStudents.getSelectedRow() + i);
        }
        model.removeRow(tableStudents.getSelectedRow());
    }//GEN-LAST:event_buttonStudentRowRemoveActionPerformed

    private void buttonStudentSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStudentSortActionPerformed
        // TODO add your handling code here:
        DefaultTableModel sortstudent = (DefaultTableModel) studentValid.getModel();
        DefaultTableModel confirm = (DefaultTableModel) tableStudents.getModel();

        String sortarray[][] = new String[sortstudent.getRowCount()][sortstudent.getColumnCount()];

        for (int i = 0; i < sortarray.length; i++) {
            for (int j = 0; j < sortarray[i].length; j++) {
                if (sortstudent.getValueAt(i, j) != null) {
                    sortarray[i][j] = String.valueOf(sortstudent.getValueAt(i, j));
                } else {
                    sortarray[i][j] = "";
                }
            }
        }

        sortbyColumn(sortarray, comboStudentFilter.getSelectedIndex());

        for (int i = 0; i < sortarray.length; i++) {
            for (int j = 0; j < sortarray[i].length; j++) {
                // sortstudent.setValueAt(sortarray[i][j], i, j);
                confirm.setValueAt(sortarray[i][j], i, j);
            }
        }
    }//GEN-LAST:event_buttonStudentSortActionPerformed

    private void buttonStudentFilterResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStudentFilterResetActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableStudents.getModel();
        DefaultTableModel valid = (DefaultTableModel) studentValid.getModel();

        model.setRowCount(valid.getRowCount());

        for (int i = 0; i < valid.getRowCount(); i++) {
            for (int j = 0; j < valid.getColumnCount(); j++) {
                model.setValueAt(valid.getValueAt(i, j), i, j);
            }
        }
    }//GEN-LAST:event_buttonStudentFilterResetActionPerformed

    private void buttonStudentValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStudentValidateActionPerformed
        // TODO add your handling code here:
        // tableStudents.getValueAt(0, 0);
        int confirmvalid = JOptionPane.showConfirmDialog(null, "This will overwrite current validated list with the current one. Are you sure?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (confirmvalid == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) tableStudents.getModel();
            DefaultTableModel valid = (DefaultTableModel) studentValid.getModel();

            valid.setRowCount(model.getRowCount());
            valid.setColumnCount(model.getColumnCount());

            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    valid.setValueAt(model.getValueAt(i, j), i, j);
                }
            }
        }
    }//GEN-LAST:event_buttonStudentValidateActionPerformed

    private void buttonStudentDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStudentDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) tableStudents.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_buttonStudentDeleteActionPerformed

    private void buttonStudentRowAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStudentRowAddActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableStudents.getModel();
        model.addRow(new Object[]{});
    }//GEN-LAST:event_buttonStudentRowAddActionPerformed

    private void buttonStudentFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStudentFilterActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableStudents.getModel();
        DefaultTableModel valid = (DefaultTableModel) studentValid.getModel();

        model.setRowCount(0);

        int action = comboStudentFilter.getSelectedIndex();

        String filter = textFieldStudentFilter.getText();
        for (int i = 0; i < valid.getRowCount(); i++) {
            String search = String.valueOf(valid.getValueAt(i, action));
            if (search.toLowerCase().contains(filter.toLowerCase())) {
                model.addRow(new Object[]{valid.getValueAt(i, 0), valid.getValueAt(i, 1), valid.getValueAt(i, 2), valid.getValueAt(i, 3), valid.getValueAt(i, 4), valid.getValueAt(i, 5)});
            }
        }
    }//GEN-LAST:event_buttonStudentFilterActionPerformed

    private void tableStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStudentsMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableStudents.getModel();

        if (tableStudents.getSelectedRowCount() > 0 && tableStudents.isFocusOwner()) {
            int selected = tableStudents.getSelectedRow();

            if (model.getValueAt(selected, 0) != null) { textStudentNumber.setText(String.valueOf(model.getValueAt(selected, 0))); } else { textStudentNumber.setText(""); }
            if (model.getValueAt(selected, 1) != null) { textStudentName.setText(String.valueOf(model.getValueAt(selected, 1))); } else { textStudentName.setText(""); }
            if (model.getValueAt(selected, 2) != null) { textStudentEmail.setText(String.valueOf(model.getValueAt(selected, 2))); } else { textStudentEmail.setText(""); }
            if (model.getValueAt(selected, 3) != null) { textStudentEMailAlt.setText(String.valueOf(model.getValueAt(selected, 3))); } else { textStudentEMailAlt.setText(""); }
            if (model.getValueAt(selected, 4) != null) { textStudentDept.setText(String.valueOf(model.getValueAt(selected, 4))); } else { textStudentDept.setText(""); }
            if (model.getValueAt(selected, 5) != null) { textStudentPhone.setText(String.valueOf(model.getValueAt(selected, 5))); } else { textStudentPhone.setText(""); }
            if (model.getValueAt(selected, 6) != null) { textStudentDept.setText(String.valueOf(model.getValueAt(selected, 6))); } else { textStudentFB.setText(""); }
            if (model.getValueAt(selected, 7) != null) {
                String status = String.valueOf(model.getValueAt(selected, 7));
                if (status.equalsIgnoreCase("active")) { comboStudentStatus.setSelectedIndex(0); }
                else if (status.equalsIgnoreCase("inactive")) { comboStudentStatus.setSelectedIndex(1); }
                else if (status.equalsIgnoreCase("graduated")) { comboStudentStatus.setSelectedIndex(2); }
                else { comboStudentStatus.setSelectedIndex(0); }
            } else { comboStudentStatus.setSelectedIndex(0); }
        }
    }//GEN-LAST:event_tableStudentsMouseClicked

    private void tableStudentsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableStudentsFocusLost
        // TODO add your handling code here:
        //tableStudents.isFocusOwner()
    }//GEN-LAST:event_tableStudentsFocusLost

    private void tableStudentsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableStudentsFocusGained
        // TODO add your handling code here:
        /*DefaultTableModel model = (DefaultTableModel) tableStudents.getModel();

        if (tableStudents.getSelectedRowCount() > 0 && tableStudents.isFocusOwner()) {
            int selected = tableStudents.getSelectedRow();

            if (model.getValueAt(selected, 0) != null) { textStudentNumber.setText(String.valueOf(model.getValueAt(selected, 0))); } else { textStudentNumber.setText(""); }
            if (model.getValueAt(selected, 1) != null) { textStudentName.setText(String.valueOf(model.getValueAt(selected, 1))); } else { textStudentName.setText(""); }
            if (model.getValueAt(selected, 2) != null) { textStudentEmail.setText(String.valueOf(model.getValueAt(selected, 2))); } else { textStudentEmail.setText(""); }
            if (model.getValueAt(selected, 3) != null) { textStudentDept.setText(String.valueOf(model.getValueAt(selected, 3))); } else { textStudentDept.setText(""); }
            if (model.getValueAt(selected, 4) != null) {
                String status = String.valueOf(model.getValueAt(selected, 4));
                if (status.equalsIgnoreCase("active")) { comboStudentStatus.setSelectedIndex(0); }
                else if (status.equalsIgnoreCase("inactive")) { comboStudentStatus.setSelectedIndex(1); }
                else if (status.equalsIgnoreCase("graduated")) { comboStudentStatus.setSelectedIndex(2); }
                else { comboStudentStatus.setSelectedIndex(0); }
            } else { comboStudentStatus.setSelectedIndex(0); }
            if (model.getValueAt(selected, 5) != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
                try {
                    Date d = sdf.parse(String.valueOf(model.getValueAt(selected, 5)));
                    dateStudentEnroll.setDate(d);
                } catch (ParseException ex) {
                    System.getLogger(MainFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }
        }*/
    }//GEN-LAST:event_tableStudentsFocusGained

    private void buttonDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDashboardActionPerformed
        // TODO add your handling code here:
        labelTotalStudents.setText(String.valueOf(tableStudents.getRowCount()));
        int active = 0;
        for (int i = 0; i < tableStudents.getRowCount(); i++) {
            if (String.valueOf(tableStudents.getValueAt(i, 7)).toLowerCase().equals("active")) {
                active += 1;
            }
        }
        labelActiveStudents.setText(String.valueOf(active));
        labelTotalDepts.setText(String.valueOf(tableDepts.getRowCount()));
        labelTotalCreds.setText(String.valueOf(tableCreds.getRowCount()));
        double completionrate = 0;
        double complete = 0;
        double total = tableEnrolls.getRowCount();
        System.out.println(tableEnrolls.getRowCount());
        for (int i = 0; i < tableEnrolls.getRowCount(); i++) {
            System.out.println(tableEnrolls.getValueAt(i, 3));
            if (String.valueOf(tableEnrolls.getValueAt(i, 3)).toLowerCase().equals("complete")) {
                complete += 1;
            }
        }
        System.out.println(complete);
        System.out.println(total);
        completionrate = (complete/total)*100;
        System.out.println(completionrate);
        labelCompletionRate.setText(String.format("%.0f", completionrate) + "%");

        DefaultTableModel studs = (DefaultTableModel) tableStudents.getModel();
        DefaultTableModel recentstuds = (DefaultTableModel) tableRecentStudents.getModel();
        recentstuds.setRowCount(0);
        for (int i = 0; i < studs.getRowCount(); i++) {
            recentstuds.addRow(new Object[] { studs.getValueAt(i, 0), studs.getValueAt(i, 7) });
        }
        DefaultTableModel depts = (DefaultTableModel) tableDepts.getModel();
        DefaultTableModel recentdepts = (DefaultTableModel) tableRecentDepts.getModel();
        recentdepts.setRowCount(0);
        for (int i = 0; i < depts.getRowCount(); i++) {
            recentdepts.addRow(new Object[] { depts.getValueAt(i, 0), depts.getValueAt(i, 2) });
        }
        DefaultTableModel creds = (DefaultTableModel) tableCreds.getModel();
        DefaultTableModel recentcreds = (DefaultTableModel) tableRecentCreds.getModel();
        recentcreds.setRowCount(0);
        for (int i = 0; i < creds.getRowCount(); i++) {
            recentcreds.addRow(new Object[] { creds.getValueAt(i, 1), creds.getValueAt(i, 4), creds.getValueAt(i, 3) });
        }

        DefaultCategoryDataset credcomp = new DefaultCategoryDataset();
        double convert = 0;
        for (int i = 0; i < creds.getRowCount(); i++) {
            credcomp.addValue(Integer.valueOf(String.valueOf(creds.getValueAt(i, 4))), "Enrollees", String.valueOf(creds.getValueAt(i, 1)));
            convert = Double.valueOf(String.valueOf(creds.getValueAt(i, 5)).substring(0, String.valueOf(creds.getValueAt(i, 5)).length() - 1));
            convert = convert/100;
            complete = (double) Integer.valueOf(String.valueOf(creds.getValueAt(i, 4))) * convert;
            credcomp.addValue(complete, "Completed", String.valueOf(creds.getValueAt(i, 1)));
        }

        JFreeChart credcompchart = ChartFactory.createBarChart(
            "Credential Completion Rates",
            "",
            "",
            credcomp,
            PlotOrientation.VERTICAL,
            true,
            true,
            false);

        CategoryPlot credcompplot = (CategoryPlot) credcompchart.getPlot();
        credcompchart.getTitle().setHorizontalAlignment(org.jfree.ui.HorizontalAlignment.LEFT);
        ((BarRenderer)credcompplot.getRenderer()).setBarPainter(new StandardBarPainter());
        credcompplot.getRenderer().setSeriesPaint(0, Color.blue);
        credcompplot.getRenderer().setSeriesPaint(0, Color.green);

        ChartPanel chartPanel = new ChartPanel(credcompchart);
        panQuickAnalytics.removeAll();
        chartPanel.setPreferredSize(new java.awt.Dimension(150*creds.getRowCount(), panQuickAnalytics.getHeight()-20));
        chartPanel.setSize(150*creds.getRowCount(), panQuickAnalytics.getHeight()-20);
        chartPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        JScrollPane scrollPane = new JScrollPane(chartPanel,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new java.awt.Dimension(panQuickAnalytics.getWidth(), panQuickAnalytics.getHeight()));
        scrollPane.setSize(panQuickAnalytics.getWidth(), panQuickAnalytics.getHeight());
        panQuickAnalytics.add(scrollPane, panQuickAnalytics.getLayout());
        //panQuickAnalytics.createHorizontalScrollBar();
        panQuickAnalytics.revalidate();
        panQuickAnalytics.repaint();

        int piactive = 0;
        int inactive = 0;
        int grad = 0;

        for (int i = 0; i < studs.getRowCount(); i++) {
            switch (String.valueOf(studs.getValueAt(i, 7)).toLowerCase()) {
                case "active" -> piactive += 1;
                case "inactive" -> inactive += 1;
                case "graduated" -> grad += 1;
            }
        }

        DefaultPieDataset piestudsdata = new DefaultPieDataset();
        piestudsdata.setValue("Active", piactive);
        piestudsdata.setValue("Inactive", inactive);
        piestudsdata.setValue("Graduated", grad);

        JFreeChart piestudschart = ChartFactory.createPieChart(
            "Student Status Distribution",
            piestudsdata,
            true,    // include legend
            true,    // generate tooltips
            false);  // no URLs

        PiePlot piestudsplot = (PiePlot) piestudschart.getPlot();
        piestudsplot.setSectionPaint("Active", Color.blue);
        piestudsplot.setSectionPaint("Inactive", Color.yellow);
        piestudsplot.setSectionPaint("Graduated", Color.green);
        piestudsplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1} ({2})"));
        piestudsplot.setShadowPaint(null);
        piestudsplot.setLabelShadowPaint(null);
        piestudsplot.setLabelBackgroundPaint(Color.white);

        ChartPanel piPanel = new ChartPanel(piestudschart);
        panStudPie.removeAll();
        piPanel.setPreferredSize(new java.awt.Dimension(panStudPie.getWidth(), panStudPie.getHeight()));
        piPanel.setSize(panStudPie.getWidth(), panStudPie.getHeight());
        piPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        panStudPie.add(piPanel, panStudPie.getLayout());
        panStudPie.revalidate();
        panStudPie.repaint();
        
        DefaultTableModel enrolls = (DefaultTableModel) tableEnrolls.getModel();
        DefaultTableModel perform = (DefaultTableModel) tablePerform.getModel();
        
        /*perform.setRowCount(0);
        for (int i = 0; i < tableEnrolls.getRowCount(); i++) {
            perform.addRow(new Object[] { enrolls.getValueAt(i, 1), enrolls.getValueAt(i, 2), enrolls.getValueAt(i, 6) });
        }*/
        
        int sortint[][] = new int[enrolls.getRowCount()][2];
        
        for (int i = 0; i < enrolls.getRowCount(); i++) {
                sortint[i][0] = Integer.parseInt(String.valueOf(enrolls.getValueAt(i, 6)));
                sortint[i][1] = 0;
            }
            sortbyNumber(sortint, 0);
            perform.setRowCount(0);
            int process = sortint.length-1;
            while (process >= 0) {
                for (int i = sortint.length-1; i >= 0; i--) {
                    if (sortint[process][0] == Integer.parseInt(String.valueOf(enrolls.getValueAt(i, 6))) && sortint[i][1] == 0) {
                        perform.addRow(new Object[] { enrolls.getValueAt(i, 1), enrolls.getValueAt(i, 2), enrolls.getValueAt(i, 6) });
                        sortint[i][1] = 1;
                        process -= 1;
                        break;
                    }
                }
            }
    }//GEN-LAST:event_buttonDashboardActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JnaFileChooser ch=new JnaFileChooser();
        boolean action = ch.showSaveDialog(this);
        if (action) {
            boolean confirm = true;
            if (ch.getSelectedFile().isFile()) {
                int overwrite = JOptionPane.showConfirmDialog(null, "File already exists!\nThis may overwrite existing data.\nAre you sure?", null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (overwrite == JOptionPane.YES_OPTION) {
                    confirm = true;
                }
                if (overwrite == JOptionPane.NO_OPTION) {
                    confirm = false;
                }
            }
            if (confirm) {
                String currentDirectory = ch.getSelectedFile().getAbsolutePath();
                String directoryPath = currentDirectory + File.separator;
                File directory = new File(directoryPath);
                boolean directoryCreated = directory.mkdir();

                if (directoryCreated) {
                    System.out.println("Directory created successfully at: " + directoryPath);
                    
                    DefaultTableModel studs = (DefaultTableModel) tableStudents.getModel();
                    DefaultTableModel creds = (DefaultTableModel) tableCreds.getModel();
                    
                    int piactive = 0;
                    int inactive = 0;
                    int grad = 0;

                    for (int i = 0; i < studs.getRowCount(); i++) {
                        switch (String.valueOf(studs.getValueAt(i, 7)).toLowerCase()) {
                            case "active" -> piactive += 1;
                            case "inactive" -> inactive += 1;
                            case "graduated" -> grad += 1;
                        }
                    }

                    DefaultPieDataset piestudsdata = new DefaultPieDataset();
                    piestudsdata.setValue("Active", piactive);
                    piestudsdata.setValue("Inactive", inactive);
                    piestudsdata.setValue("Graduated", grad);

                    JFreeChart piestudschart = ChartFactory.createPieChart(
                        "Student Status Distribution",
                        piestudsdata,
                        true,    // include legend
                        true,    // generate tooltips
                        false);  // no URLs

                    PiePlot piestudsplot = (PiePlot) piestudschart.getPlot();
                    piestudsplot.setSectionPaint("Active", Color.blue);
                    piestudsplot.setSectionPaint("Inactive", Color.yellow);
                    piestudsplot.setSectionPaint("Graduated", Color.green);
                    piestudsplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1} ({2})"));
                    piestudsplot.setShadowPaint(null);
                    piestudsplot.setLabelShadowPaint(null);
                    piestudsplot.setLabelBackgroundPaint(Color.white);
                    
                    DefaultCategoryDataset credcomp = new DefaultCategoryDataset();
                    double convert = 0;
                    double complete = 0;
                    for (int i = 0; i < creds.getRowCount(); i++) {
                        credcomp.addValue(Integer.valueOf(String.valueOf(creds.getValueAt(i, 4))), "Enrollees", String.valueOf(creds.getValueAt(i, 1)));
                        convert = Double.valueOf(String.valueOf(creds.getValueAt(i, 5)).substring(0, String.valueOf(creds.getValueAt(i, 5)).length() - 1));
                        convert = convert/100;
                        complete = (double) Integer.valueOf(String.valueOf(creds.getValueAt(i, 4))) * convert;
                        credcomp.addValue(complete, "Completed", String.valueOf(creds.getValueAt(i, 1)));
                    }

                    JFreeChart credcompchart = ChartFactory.createBarChart(
                        "Credential Completion Rates",
                        "",
                        "",
                        credcomp,
                        PlotOrientation.VERTICAL,
                        true,
                        true,
                        false);

                    CategoryPlot credcompplot = (CategoryPlot) credcompchart.getPlot();
                    credcompchart.getTitle().setHorizontalAlignment(org.jfree.ui.HorizontalAlignment.LEFT);
                    ((BarRenderer)credcompplot.getRenderer()).setBarPainter(new StandardBarPainter());
                    credcompplot.getRenderer().setSeriesPaint(0, Color.blue);
                    credcompplot.getRenderer().setSeriesPaint(0, Color.green);

                    int width = 640;    /* Width of the image */
                    int height = 480;   /* Height of the image */
                    File piChart = new File( directoryPath + "Student Chart.jpeg" );
                    try {
                        ChartUtilities.saveChartAsJPEG( piChart , piestudschart , width , height );
                    } catch (IOException ex) {
                        System.getLogger(MainFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                    int width2 = 250 + (150*creds.getRowCount());    /* Width of the image */
                    int height2 = 480;   /* Height of the image */
                    File barChart = new File( directoryPath + "Creds Chart.jpeg" );
                    try {
                        ChartUtilities.saveChartAsJPEG( barChart , credcompchart , width2 , height2 );
                    } catch (IOException ex) {
                        System.getLogger(MainFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "Analytics exported!");
                } else {
                    System.out.println("Failed to create directory. It may already exist at: " + directoryPath);
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //System.setProperty("sun.java2d.uiScale.enabled", "true");
        //System.setProperty("sun.java2d.uiScale", "2.0");
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddDept;
    private javax.swing.JButton buttonAddSession;
    private javax.swing.JButton buttonAddStudent;
    private javax.swing.JButton buttonDashboard;
    private javax.swing.JButton buttonDelAll;
    private javax.swing.JButton buttonDeptDelete;
    private javax.swing.JButton buttonDeptFilter;
    private javax.swing.JButton buttonDeptFilterReset;
    private javax.swing.JButton buttonDeptRowAdd;
    private javax.swing.JButton buttonDeptRowRemove;
    private javax.swing.JButton buttonDeptSort;
    private javax.swing.JButton buttonDeptUpdate;
    private javax.swing.JButton buttonDeptValidate;
    private javax.swing.JButton buttonExport;
    private javax.swing.JButton buttonExportAll;
    private javax.swing.JButton buttonFilterCred;
    private javax.swing.JButton buttonFilterCredReset;
    private javax.swing.JButton buttonFilterEnroll;
    private javax.swing.JButton buttonImport;
    private javax.swing.JButton buttonImportAll;
    private javax.swing.JButton buttonNewCred;
    private javax.swing.JButton buttonRemoveDate;
    private javax.swing.JButton buttonSchedFilter;
    private javax.swing.JButton buttonSchedFilterReset;
    private javax.swing.JButton buttonSchedSort;
    private javax.swing.JButton buttonSortCred;
    private javax.swing.JButton buttonSortEnroll;
    private javax.swing.JButton buttonStudentDelete;
    private javax.swing.JButton buttonStudentFilter;
    private javax.swing.JButton buttonStudentFilterReset;
    private javax.swing.JButton buttonStudentRowAdd;
    private javax.swing.JButton buttonStudentRowRemove;
    private javax.swing.JButton buttonStudentSort;
    private javax.swing.JButton buttonStudentUpdate;
    private javax.swing.JButton buttonStudentValidate;
    private javax.swing.JButton buttonValAll;
    private javax.swing.JButton buttonValidDate;
    public com.toedter.calendar.JCalendar calendarSessions;
    private javax.swing.JComboBox<String> comboDeptFilter;
    private javax.swing.JComboBox<String> comboDeptStatus;
    private javax.swing.JComboBox<String> comboFilterCred;
    private javax.swing.JComboBox<String> comboFilterEnroll;
    private javax.swing.JComboBox<String> comboSchedFilter;
    private javax.swing.JComboBox<String> comboStudentFilter;
    private javax.swing.JComboBox<String> comboStudentStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JLabel labelActiveStudents;
    private javax.swing.JLabel labelCompletionRate;
    private javax.swing.JLabel labelCurrentDesc;
    private javax.swing.JLabel labelCurrentTab;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelSessionAttend2;
    private javax.swing.JLabel labelSessionComplete2;
    private javax.swing.JLabel labelSessionOngoing2;
    private javax.swing.JLabel labelSessionRate2;
    private javax.swing.JLabel labelSessionTotal2;
    private javax.swing.JLabel labelTotalCreds;
    private javax.swing.JLabel labelTotalDepts;
    private javax.swing.JLabel labelTotalStudents;
    private javax.swing.JScrollPane panQuickAnalytics;
    private javax.swing.JPanel panStudPie;
    private javax.swing.JPanel panelCredList;
    private javax.swing.JPanel panelDashboard;
    private javax.swing.JPanel panelDept;
    private javax.swing.JPanel panelSchedView;
    private javax.swing.JPanel panelStudents;
    private javax.swing.JSpinner spinnerDeptDate;
    private javax.swing.JSpinner spinnerDeptStudents;
    private javax.swing.JTable tableCreds;
    private javax.swing.JTable tableDepts;
    private javax.swing.JTable tableEnrolls;
    private javax.swing.JTable tablePerform;
    private javax.swing.JTable tableRecentCreds;
    private javax.swing.JTable tableRecentDepts;
    private javax.swing.JTable tableRecentStudents;
    private javax.swing.JTable tableSchedList;
    public javax.swing.JTable tableStudents;
    private javax.swing.JTextArea textAreaLoaded;
    private javax.swing.JTextField textDeptHead;
    private javax.swing.JTextField textDeptName;
    private javax.swing.JTextField textFieldDeptFilter;
    private javax.swing.JTextField textFieldFilterCred;
    private javax.swing.JTextField textFieldFilterEnroll;
    private javax.swing.JTextField textFieldSchedFilter;
    private javax.swing.JTextField textFieldStudentFilter;
    private javax.swing.JTextField textStudentDept;
    private javax.swing.JTextField textStudentEMailAlt;
    private javax.swing.JTextField textStudentEmail;
    private javax.swing.JTextField textStudentFB;
    private javax.swing.JTextField textStudentName;
    private javax.swing.JTextField textStudentNumber;
    private javax.swing.JTextField textStudentPhone;
    // End of variables declaration//GEN-END:variables
}
