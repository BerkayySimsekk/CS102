import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CatalogGUI extends JFrame {
    JPanel centerPanel;
    JPanel eastPanel;
    JPanel southPanel;
    JRadioButton english;
    JRadioButton turkish;
    JCheckBox hidePrice;
    JButton next;
    JButton previous;
    JTextField enterCode;
    JTextField enterPrice;
    JTextArea itemInfo;
    JLabel code;
    JLabel price;
    JLabel description;
    Catalog catalog;

    public CatalogGUI() {
        this.setSize(298, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400,300);
        this.setTitle("Browse Product Catalog");
        this.setResizable(false);
        designWindow();
        this.setVisible(true);
    }

    private void designWindow() {
        catalog = new Catalog();

        centerPanel = new JPanel();
        eastPanel = new JPanel();
        southPanel = new JPanel();

        eastPanel.setLayout(new GridLayout(3, 1, 0, 0));
        centerPanel.setBackground(Color.WHITE);

        enterCode = new JTextField(10);
        enterPrice = new JTextField(10);

        enterCode.setEditable(false);
        enterCode.setText(String.valueOf(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getProductCode()));
        enterPrice.setEditable(false);
        enterPrice.setText(String.valueOf(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getPrice()));

        code = new JLabel("CODE");
        price = new JLabel("PRICE");
        description = new JLabel("DESCRIPTION");

        itemInfo = new JTextArea(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getEngDescription());

        itemInfo.setBackground(Color.LIGHT_GRAY);

        english = new JRadioButton("English");
        turkish = new JRadioButton("Turkish");

        english.setSelected(true);

        ButtonGroup group = new ButtonGroup();
		group.add(english);
		group.add(turkish);

        english.addActionListener(new EnglishListener());
        turkish.addActionListener(new TurkishListener());

        hidePrice = new JCheckBox("HIDE PRICE");

        hidePrice.addActionListener(new HidePriceListener());

        next = new JButton(">>>");
        previous = new JButton("<<<");

        next.addActionListener(new NextListener());
        previous.addActionListener(new PreviousListener());

        centerPanel.add(code);
        centerPanel.add(enterCode);
        centerPanel.add(price);
        centerPanel.add(enterPrice);
        centerPanel.add(description);
        centerPanel.add(itemInfo);

        eastPanel.add(english);
        eastPanel.add(turkish);
        eastPanel.add(hidePrice);

        southPanel.add(previous);
        southPanel.add(next);

        this.add(centerPanel, BorderLayout.CENTER);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
    }

    private class NextListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(english.isSelected()) {
                if(catalog.getCurrentProdIndex() != catalog.getCatalogSize() - 1) {
                    catalog.setCurrentProdIndex(catalog.getCurrentProdIndex() + 1);
                    enterCode.setText(String.valueOf(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getProductCode()));
                    enterPrice.setText(String.valueOf(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getPrice()));
                    itemInfo.setText(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getEngDescription());
                }
                else {
                    catalog.setCurrentProdIndex(0);
                    enterCode.setText(String.valueOf(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getProductCode()));
                    enterPrice.setText(String.valueOf(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getPrice()));
                    itemInfo.setText(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getEngDescription());
                }   
            }
            
            if(turkish.isSelected()) {
                if(catalog.getCurrentProdIndex() != catalog.getCatalogSize() - 1) {
                    catalog.setCurrentProdIndex(catalog.getCurrentProdIndex() + 1);
                    enterCode.setText(String.valueOf(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getProductCode()));
                    enterPrice.setText(String.valueOf(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getPrice()));
                    itemInfo.setText(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getTurkDescription());
                }
                else {
                    catalog.setCurrentProdIndex(0);
                    enterCode.setText(String.valueOf(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getProductCode()));
                    enterPrice.setText(String.valueOf(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getPrice()));
                    itemInfo.setText(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getTurkDescription());
                }   
            }
        }
        
    }

    private class PreviousListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(english.isSelected()) {
                if(catalog.getCurrentProdIndex() != 0) {
                    catalog.setCurrentProdIndex(catalog.getCurrentProdIndex() - 1);
                    enterCode.setText(String.valueOf(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getProductCode()));
                    enterPrice.setText(String.valueOf(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getPrice()));
                    itemInfo.setText(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getEngDescription());
                }
                else {
                    catalog.setCurrentProdIndex(catalog.getCatalogSize() - 1);
                    enterCode.setText(String.valueOf(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getProductCode()));
                    enterPrice.setText(String.valueOf(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getPrice()));
                    itemInfo.setText(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getEngDescription());
                }   
            }
            
            if(turkish.isSelected()) {
                if(catalog.getCurrentProdIndex() != 0) {
                    catalog.setCurrentProdIndex(catalog.getCurrentProdIndex() - 1);
                    enterCode.setText(String.valueOf(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getProductCode()));
                    enterPrice.setText(String.valueOf(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getPrice()));
                    itemInfo.setText(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getTurkDescription());
                }
                else {
                    catalog.setCurrentProdIndex(catalog.getCatalogSize() - 1);
                    enterCode.setText(String.valueOf(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getProductCode()));
                    enterPrice.setText(String.valueOf(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getPrice()));
                    itemInfo.setText(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getTurkDescription());
                }   
            }
        }
        
    }

    private class EnglishListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            itemInfo.setText(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getEngDescription());  
        }
        
    }

    private class TurkishListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            itemInfo.setText(catalog.getProductByPosition(catalog.getCurrentProdIndex()).getTurkDescription());
        }
        
    }

    private class HidePriceListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(hidePrice.isSelected()) {
                price.setVisible(false);
                enterPrice.setVisible(false);
            }
            else {
                price.setVisible(true);
                enterPrice.setVisible(true);   
            }
        }
        
    }
}
