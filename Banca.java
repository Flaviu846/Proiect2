import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.lang.*;

class ContBancar{

    private String CNP;
    private double sold;
    boolean datorie;
    static boolean IN_DATORIE=true;
    static boolean NU_DATORIE=false;

    public ContBancar(String  CNP, double sold,boolean datorie) {
        this.CNP=CNP;
        this.sold=sold;
        this.datorie=datorie;

    }
    public ContBancar(){
        this.CNP="nedefinit";
        this.sold=0;
        this.datorie=false;
    }

    public double getSold() {
        return sold;
    }
    public void setSold(double sold){
        this.sold=sold;
    }
    public String getCNP(){
        return  CNP;
    }
    public void setCNP(String CNP){
        this.CNP=CNP;
    }
    public boolean getDatorie(boolean datorie){
        return  datorie;
    }
    public void setDatorie(boolean datorie){
        this.datorie=datorie;
    }
    public String toString()
    {
        StringBuffer sr=new StringBuffer();
        sr.append("CNP: ");
        sr.append(CNP);
        sr.append((" cu soldul: "));
        sr.append(sold);
        if(datorie)
            sr.append(" este in datorie ");
        else
            sr.append(" nu este in datorie ");
        return sr.toString();
    }
}


public class Banca {
    ArrayList<ContBancar> cont=new ArrayList<>();
    private JTextField textField1;
    private JLabel CNP;
    private JTextField textField2;
    private JTextArea textArea1;
    private JPanel rootPanel;
    private JTextField textField3;
    private JButton adaugareClientButton;
    private JCheckBox datorieCheckBox;
    private JTextField textField4;
    private JButton modificareSoldButton;
    private JButton ClearAll;
    private JButton stergereClientButton;
    private JTextField textField5;
    String _cnp;
    double _sold;
    static boolean IN_DATORIE=true;
    static boolean NU_DATORIE=false;
    boolean datorie;
    int nr=0;
    int id;
    public Banca() {
        adaugareClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Eroare, camp incorect","Eroare",JOptionPane.ERROR_MESSAGE);
                else
                _cnp=textField1.getText();
                if(textField4.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Eroare, camp incorect","Eroare",JOptionPane.ERROR_MESSAGE);
                else
                _sold=Double.parseDouble(textField4.getText());

                datorie=datorieCheckBox.isSelected();
                cont.add(new ContBancar(_cnp,_sold,datorie));
                textArea1.append("ID:");
                textArea1.append(Integer.toString(nr));
                textArea1.append(" ");
                textArea1.append(cont.get(nr).toString());
                textArea1.append("\n");
                nr++;
            }
        });

        modificareSoldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Eroare, camp incorect","Eroare",JOptionPane.ERROR_MESSAGE);
                else
                id=Integer.parseInt( textField3.getText());
               cont.get(id).setSold(Double.parseDouble(textField2.getText()));
               textArea1.append("Client id: ");
               textArea1.append(Integer.toString(id));
               textArea1.append(" Sold modificat in: ");
               textArea1.append(Double.toString(cont.get(id).getSold()));
            }
        });
        ClearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                cont.clear();
                nr=0;
            }
        });
        stergereClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int stclient= Integer.parseInt(textField5.getText());
                if(stclient>nr)
                        JOptionPane.showMessageDialog(null,"Eroare, camp incorect","Eroare",JOptionPane.ERROR_MESSAGE);
                    else {
                    cont.remove(stclient);
                    textArea1.append("Cont client eliminat cu id-ul: ");
                    textArea1.append(Integer.toString(stclient));
                    textArea1.append("\n");
                    nr--;
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame=new JFrame("Aplicatie Cont Bancar");
        frame.setContentPane(new Banca().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
