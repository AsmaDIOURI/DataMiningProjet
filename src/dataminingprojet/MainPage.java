package dataminingprojet;


import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.evaluation.ThresholdCurve;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Discretize;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.instance.RemoveFrequentValues;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;
import weka.gui.visualize.PlotData2D;
import weka.gui.visualize.ThresholdVisualizePanel;

public class MainPage extends javax.swing.JFrame {

    DataSource source;
    private int validDB;
    private String SourceDB;
    ArffSaver saver;
    File output;

    //Creates new form MainPage 
    public MainPage() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        Classifieur = new javax.swing.ButtonGroup();
        Filtre = new javax.swing.ButtonGroup();
        SourceBD = new javax.swing.JTextField();
        ChoisirBD = new javax.swing.JButton();
        LabelBD = new javax.swing.JLabel();
        DataBaseScroll = new javax.swing.JScrollPane();
        DataBaseArea = new javax.swing.JTextArea();
        FiltreLabel = new javax.swing.JLabel();
        ApplyButton = new javax.swing.JButton();
        DiscretisationAttributeIndex = new javax.swing.JSpinner();
        Classifieur1 = new javax.swing.JRadioButton();
        ClassificationLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        KValue = new javax.swing.JSpinner();
        KLabel = new javax.swing.JLabel();
        DiscretisationFilter = new javax.swing.JRadioButton();
        RemoveFilter = new javax.swing.JRadioButton();
        RemoveAttributeIndex = new javax.swing.JSpinner();
        ClassificationScroll = new javax.swing.JScrollPane();
        ClassifacationArea = new javax.swing.JTextArea();
        Classifieur3 = new javax.swing.JRadioButton();
        RemoveFrequentValuesFilter = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        RemoveFrequentValuesIndex = new javax.swing.JSpinner();
        N = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SourceBD.setEditable(false);
        SourceBD.setToolTipText("chemin du fichier");
        SourceBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SourceBDActionPerformed(evt);
            }
        });

        ChoisirBD.setText("go!");
        ChoisirBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoisirBDActionPerformed(evt);
            }
        });

        LabelBD.setText("Base de Donnée");

        DataBaseArea.setColumns(20);
        DataBaseArea.setRows(5);
        DataBaseScroll.setViewportView(DataBaseArea);

        FiltreLabel.setText("Filtres:");

        ApplyButton.setText("Appliquer");
        ApplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplyButtonActionPerformed(evt);
            }
        });

        Classifieur.add(Classifieur1);
        Classifieur1.setText("Naive Bayes");
        Classifieur1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Classifieur1StateChanged(evt);
            }
        });
        Classifieur1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Classifieur1ActionPerformed(evt);
            }
        });

        ClassificationLabel.setText("Classification:");

        jButton1.setText("Valider");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        KLabel.setText("K");

        Filtre.add(DiscretisationFilter);
        DiscretisationFilter.setText("Discretisation");

        Filtre.add(RemoveFilter);
        RemoveFilter.setText("Remove");

        ClassifacationArea.setColumns(20);
        ClassifacationArea.setRows(5);
        ClassificationScroll.setViewportView(ClassifacationArea);

        Classifieur.add(Classifieur3);
        Classifieur3.setSelected(true);
        Classifieur3.setText("J 48");

        Filtre.add(RemoveFrequentValuesFilter);
        RemoveFrequentValuesFilter.setText("RemoveFrequentValues");

        jLabel1.setText("Index");

        jLabel2.setText("N:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(FiltreLabel)
                                .addGap(127, 127, 127)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(DiscretisationFilter)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(DiscretisationAttributeIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(RemoveFilter)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(RemoveAttributeIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(RemoveFrequentValuesFilter)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RemoveFrequentValuesIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(N, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelBD)
                                .addGap(29, 29, 29)
                                .addComponent(SourceBD, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(ChoisirBD))
                            .addComponent(ApplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(ClassificationLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(KLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(KValue, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(Classifieur1)
                                            .addGap(18, 18, 18)
                                            .addComponent(Classifieur3))
                                        .addComponent(jButton1))
                                    .addGap(34, 34, 34)
                                    .addComponent(ClassificationScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(DataBaseScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 127, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelBD, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SourceBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChoisirBD, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DataBaseScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FiltreLabel)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DiscretisationAttributeIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DiscretisationFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RemoveFilter)
                    .addComponent(RemoveAttributeIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RemoveFrequentValuesFilter)
                    .addComponent(RemoveFrequentValuesIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ApplyButton)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ClassificationLabel)
                            .addComponent(KValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KLabel))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Classifieur3)
                            .addComponent(Classifieur1))
                        .addGap(61, 61, 61)
                        .addComponent(jButton1))
                    .addComponent(ClassificationScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SourceBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SourceBDActionPerformed

    }//GEN-LAST:event_SourceBDActionPerformed

    //choisir path DB
    private void ChoisirBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoisirBDActionPerformed
        validDB = jFileChooser1.showOpenDialog(MainPage.this);
        if (validDB == JFileChooser.APPROVE_OPTION) {
            this.SourceBD.setText(jFileChooser1.getSelectedFile().getPath());
            SourceDB = jFileChooser1.getSelectedFile().getPath();
            afficheDataBase();
        }
    }//GEN-LAST:event_ChoisirBDActionPerformed

    private void Classifieur1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Classifieur1StateChanged

    }//GEN-LAST:event_Classifieur1StateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if (Classifieur1.isSelected()) {
            try {
                Instances dataset = source.getDataSet();
                dataset.setClassIndex(dataset.numAttributes() - 1);

                NaiveBayes nb = new NaiveBayes();

                int seed = 1;

                int k = (int) KValue.getValue();
                String s2 = Integer.toString(k);
                int i = Integer.parseInt(s2);

                int folds = i;

                Random rand = new Random(seed);

                //create random dataset
                Instances randData = new Instances(dataset);
                randData.randomize(rand);

                if (randData.classAttribute().isNominal()) {
                    randData.stratify(folds);
                }

                //evaluate classifyier 
                Evaluation eval = new Evaluation(dataset);
                eval.crossValidateModel(nb, dataset, folds, new Random(1));

                ClassifacationArea.setText("Evaluation de NaiveBayes avec K=" + folds);
                ClassifacationArea.setText(ClassifacationArea.getText() + eval.toMatrixString("\nConfusion matrix"));
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nCorrect Instance = " + eval.correct());
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nIncorrect Instance = " + eval.incorrect());
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nCorrect % = " + eval.pctCorrect());
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nIncorrect % = " + eval.pctIncorrect());
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nKappa statistic = " + eval.kappa());
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nMean absolute error = " + eval.meanAbsoluteError());
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nRoot mean squared error = " + eval.rootMeanSquaredError());
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nRelative absolute error = " + eval.relativeAbsoluteError());
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nRoot relative squared error = " + eval.rootRelativeSquaredError());
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nError Rate = " + eval.errorRate());


            } catch (Exception ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (Classifieur3.isSelected()) {
            try {
                Instances dataset = source.getDataSet();
                dataset.setClassIndex(dataset.numAttributes() - 1);

                //create the classifier
                J48 j48 = new J48();
                int seed = 1;
                int k = (int) KValue.getValue();
                String s2 = Integer.toString(k);
                int i = Integer.parseInt(s2);
                int folds = i;
                
                //create random dataset
                Evaluation eval = new Evaluation(dataset);
                eval.crossValidateModel(j48, dataset, folds, new Random(1));
                System.out.print(j48.toString());

                ClassifacationArea.setText("Evaluation de J48 avec K=" + folds);
                ClassifacationArea.setText(ClassifacationArea.getText() + eval.toMatrixString("\nConfusion matrix"));
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nCorrect Instance = " + eval.correct());
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nIncorrect Instance = " + eval.incorrect());
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nCorrect % = " + eval.pctCorrect());
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nIncorrect % = " + eval.pctIncorrect());
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nKappa statistic = " + eval.kappa());
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nMean absolute error = " + eval.meanAbsoluteError());
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nRoot mean squared error = " + eval.rootMeanSquaredError());
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nRelative absolute error = " + eval.relativeAbsoluteError());
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nRoot relative squared error = " + eval.rootRelativeSquaredError());
                ClassifacationArea.setText(ClassifacationArea.getText() + "\nError Rate = " + eval.errorRate());

                j48.buildClassifier(dataset);
                
                //predict
                Instances unpredicted = DataSource.read("test.arff");
                unpredicted.setClassIndex(unpredicted.numAttributes()-1);
                
                Instances predicted = new Instances(unpredicted);
                
                for (int j =0 ; j < unpredicted.numInstances() ;j++){
                    double clsLabel = j48.classifyInstance(unpredicted.instance(j));
                    predicted.instance(j).setClassValue(clsLabel);
                }
                ConverterUtils.DataSink.write("predicted.arff", predicted);
                //
                
                final javax.swing.JFrame jf
                        = new javax.swing.JFrame("Weka Classifier Tree Visualizer: J48");
                jf.setSize(1300, 700);
                jf.getContentPane().setLayout(new BorderLayout());
                TreeVisualizer tv = new TreeVisualizer(null,
                        j48.graph(),
                        new PlaceNode2());
                jf.getContentPane().add(tv, BorderLayout.CENTER);
                jf.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        jf.dispose();
                    }
                });
                jf.setVisible(true);
                tv.fitToScreen();

                
            } catch (Exception ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ApplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyButtonActionPerformed
        if (DiscretisationFilter.isSelected()) {
            try {
                Instances dataset = source.getDataSet();

                String[] options = new String[2];
                options[0] = "-R";
                int index = (int) DiscretisationAttributeIndex.getValue();
                String s1 = Integer.toString(index);
                options[1] = s1;
                Discretize discretize = new Discretize();
                discretize.setOptions(options);
                discretize.setInputFormat(dataset);
                Instances newData = Filter.useFilter(dataset, discretize);

                BufferedWriter writer = new BufferedWriter(new FileWriter("temp.arff"));
                writer.write(newData.toString());
                writer.flush();
                writer.close();
                source = new DataSource("temp.arff");
                dataset = source.getDataSet();
                DataBaseArea.setText(dataset.toSummaryString());
            } catch (Exception ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (RemoveFilter.isSelected()) {
            try {
                Instances dataset = source.getDataSet();
                
                String[] options = new String[2];
                options[0] = "-R";
                int index = (int) RemoveAttributeIndex.getValue();
                String s1 = Integer.toString(index);
                options[1] = s1;
                Remove remove = new Remove();
                remove.setOptions(options);
                remove.setInputFormat(dataset);
                Instances newData = Filter.useFilter(dataset, remove);
                
                BufferedWriter writer = new BufferedWriter(new FileWriter("temp.arff"));
                writer.write(newData.toString());
                writer.flush();
                writer.close();
                source = new DataSource("temp.arff");
                dataset = source.getDataSet();
                DataBaseArea.setText(dataset.toSummaryString());
            } catch (Exception ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (RemoveFrequentValuesFilter.isSelected()) {
            try {
                Instances dataset = source.getDataSet();
                
                String[] options = new String[4];
                options[0] = "-C";
                int index = (int) RemoveFrequentValuesIndex.getValue();
                String s1 = Integer.toString(index);
                options[1] = s1;

                options[2] = "-N";
                int n = (int) N.getValue();
                s1 = Integer.toString(index);
                options[3] = s1;

                RemoveFrequentValues rf = new RemoveFrequentValues();
                rf.setOptions(options);
                rf.setInputFormat(dataset);
                Instances newData = Filter.useFilter(dataset, rf);

                BufferedWriter writer = new BufferedWriter(new FileWriter("temp.arff"));
                writer.write(newData.toString());
                writer.flush();
                writer.close();
                source = new DataSource("temp.arff");
                dataset = source.getDataSet();
                DataBaseArea.setText(dataset.toSummaryString());
            } catch (Exception ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ApplyButtonActionPerformed

    private void Classifieur1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Classifieur1ActionPerformed
    }//GEN-LAST:event_Classifieur1ActionPerformed

    private void afficheDataBase() {
        try {
            source = new ConverterUtils.DataSource(SourceDB);
            Instances dataset = source.getDataSet();
            DataBaseArea.setText(dataset.toSummaryString());
        } catch (Exception ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApplyButton;
    private javax.swing.JButton ChoisirBD;
    private javax.swing.JTextArea ClassifacationArea;
    private javax.swing.JLabel ClassificationLabel;
    private javax.swing.JScrollPane ClassificationScroll;
    private javax.swing.ButtonGroup Classifieur;
    private javax.swing.JRadioButton Classifieur1;
    private javax.swing.JRadioButton Classifieur3;
    private javax.swing.JTextArea DataBaseArea;
    private javax.swing.JScrollPane DataBaseScroll;
    private javax.swing.JSpinner DiscretisationAttributeIndex;
    private javax.swing.JRadioButton DiscretisationFilter;
    private javax.swing.ButtonGroup Filtre;
    private javax.swing.JLabel FiltreLabel;
    private javax.swing.JLabel KLabel;
    private javax.swing.JSpinner KValue;
    private javax.swing.JLabel LabelBD;
    private javax.swing.JSpinner N;
    private javax.swing.JSpinner RemoveAttributeIndex;
    private javax.swing.JRadioButton RemoveFilter;
    private javax.swing.JRadioButton RemoveFrequentValuesFilter;
    private javax.swing.JSpinner RemoveFrequentValuesIndex;
    private javax.swing.JTextField SourceBD;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
