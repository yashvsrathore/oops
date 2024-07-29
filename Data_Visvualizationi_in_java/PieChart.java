package com.company;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PieChart {
private JTextField item;
private JTextField amount;
private JButton ADDDATAButton;
private JPanel mainFrame;
private JPanel panel2;
private JButton PIECHARTButton;
private JPanel piePanel;
private JButton RESETButton;
private DefaultPieDataset pieDataset;
private JFreeChart pieChart;
private ChartPanel chartPanel;
DefaultTableModel model;
JTable table;
JFrame frame = new JFrame();
public PieChart() {
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setContentPane(mainFrame);
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);
displayTable();
ADDDATAButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String itemName = item.getText();
String amountData = amount.getText();
Object[] data = {itemName,amountData};
model.addRow(data);
item.setText("");
amount.setText("");
}
});
PIECHARTButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
piePanel.removeAll();
showPie();
frame.validate();
}
});
RESETButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
piePanel.removeAll();
panel2.removeAll();
displayTable();
frame.validate();
}
});
}
public void displayTable(){
String[] a = {"ITEMS","AMOUNT"};
model = new DefaultTableModel(null,a);
table = new JTable(model);
panel2.add(new JScrollPane(table));
}
public void showPie(){
pieDataset = new DefaultPieDataset();
for(int i=0;i<table.getRowCount();i++){
String name = table.getValueAt(i,0).toString();
Double amt = Double.valueOf(table.getValueAt(i,1).toString());
pieDataset.setValue(name,amt);
}
pieChart = ChartFactory.createPieChart("PIE CHART",pieDataset,true,true,true);
pieChart.getPlot();
chartPanel = new ChartPanel(pieChart);
piePanel.add(chartPanel);
}
}