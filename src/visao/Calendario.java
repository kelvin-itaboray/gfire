package visao;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author itaboray
 */
public final class Calendario extends javax.swing.JPanel {

    int aux = 0;
    int dia = 31;
    int qtddia = 0;
    JLabel[] arrayLb = new JLabel[42];
    Date d = new Date(System.currentTimeMillis());
    String datahoje = d.getDate() + "/" + d.getMonth() + "/" + (d.getYear() + 1900);

    public Calendario() {
        initComponents();
        pDia.setLayout(new GridLayout(6, 7));
        for (int j = 0; j < arrayLb.length; j++) {
            arrayLb[j] = new JLabel("lb" + j);
            arrayLb[j].setHorizontalAlignment(JLabel.CENTER);
            arrayLb[j].setHorizontalTextPosition(JLabel.CENTER);
            pDia.add(arrayLb[j]);
        }
        ((DefaultEditor) sAno.getEditor()).getTextField().setEditable(false);
        cbMes.setSelectedIndex(d.getMonth());
        calendario();
    }

    public void calendario() {
        for (int i = 0; i < arrayLb.length; i++) {
            arrayLb[i].setIcon(null);
            arrayLb[i].setFont(new java.awt.Font("Tahoma", 0, 15));
            arrayLb[i].setForeground(Color.GRAY);
            arrayLb[i].setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        }
        int comeco = 0;
        int j = 0;
        d.setYear(Integer.parseInt(sAno.getModel().getValue().toString()) - 1900);
        String ano = sAno.getModel().getValue().toString();
        if (cbMes.getSelectedIndex() <= 6 && cbMes.getSelectedIndex() % 2 == 0) {
            dia = 31;
        } else if (cbMes.getSelectedIndex() <= 6 && cbMes.getSelectedIndex() % 2 != 0) {
            dia = 30;
        }
        if (cbMes.getSelectedIndex() > 6 && cbMes.getSelectedIndex() % 2 == 0) {
            dia = 30;
        } else if (cbMes.getSelectedIndex() > 6 && cbMes.getSelectedIndex() % 2 != 0) {
            dia = 31;
        }
        for (int i = 0; i < 12; i++) {
            if (cbMes.getSelectedIndex() == i) {
                d.setMonth(i);
                d.setDate(1);
                comeco = d.getDay();
                if (cbMes.getSelectedIndex() == 1) {
                    if (Integer.parseInt(ano) % 4 == 0) {
                        dia = 29;
                    } else {
                        dia = 28;
                    }
                }
            }
        }
        for (int i = 0; i < arrayLb.length; i++) {
            arrayLb[i].setText("");
            arrayLb[i].setVisible(true);
            arrayLb[i].setOpaque(true);
            if (i % 2 == 0) {
                arrayLb[i].setBackground(new java.awt.Color(176, 196, 222));
            } else {
                arrayLb[i].setBackground(new java.awt.Color(70, 130, 180));
                arrayLb[i].setForeground(Color.WHITE);
            }
        }

        int k = 0;
        for (int i = comeco; k < dia; i++) {
            j = j + 1;
            k = k + 1;
            arrayLb[i].setText(j + "");
        }
        String dh[] = datahoje.split("/");
        if (Integer.parseInt(dh[2]) == Integer.parseInt(ano)) {
            if (Integer.parseInt(dh[1]) == cbMes.getSelectedIndex()) {
                int diaH = Integer.parseInt(dh[0]) + comeco - 1;
                arrayLb[diaH].setHorizontalTextPosition(JLabel.CENTER);
                arrayLb[diaH].setVerticalTextPosition(JLabel.CENTER);
                arrayLb[diaH].setForeground(Color.BLUE);
                arrayLb[diaH].setBackground(new java.awt.Color(30, 144, 255));
            }
        }
    }

    private void initComponents() {
        sAno = new JSpinner();
        cbMes = new javax.swing.JComboBox();
        pCalendario = new javax.swing.JPanel();
        lbSeg = new javax.swing.JLabel();
        lbTer = new javax.swing.JLabel();
        lbQua = new javax.swing.JLabel();
        lbQui = new javax.swing.JLabel();
        lbSex = new javax.swing.JLabel();
        lbSab = new javax.swing.JLabel();
        lbDom = new javax.swing.JLabel();
        pDia = new javax.swing.JPanel();
        lbMes = new javax.swing.JLabel();
        lbAno = new javax.swing.JLabel();
        //lbTitulo = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Calendário"));
        setOpaque(true);
        setLayout(null);

        cbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
        cbMes.addActionListener((java.awt.event.ActionEvent evt) -> {
            cbMesActionPerformed(evt);
        });
        add(cbMes);
        cbMes.setBounds(250, 70, 110, 20);

        pCalendario.setBackground(new java.awt.Color(176, 196, 220));
        pCalendario.setLayout(null);

        lbSeg.setText("    Seg");
        pCalendario.add(lbSeg);
        lbSeg.setBounds(50, 0, 50, 20);

        lbTer.setText("      Ter");
        pCalendario.add(lbTer);
        lbTer.setBounds(100, 0, 50, 20);

        lbQua.setText("    Qua");
        pCalendario.add(lbQua);
        lbQua.setBounds(150, 0, 50, 20);

        lbQui.setText("    Qui");
        pCalendario.add(lbQui);
        lbQui.setBounds(200, 0, 50, 20);

        lbSex.setText("    Sex");
        pCalendario.add(lbSex);
        lbSex.setBounds(250, 0, 50, 20);

        lbSab.setForeground(new java.awt.Color(0, 102, 255));
        lbSab.setText("    Sáb");
        pCalendario.add(lbSab);
        lbSab.setBounds(300, 0, 50, 20);

        lbDom.setForeground(new java.awt.Color(255, 0, 0));
        lbDom.setText("     Dom");
        pCalendario.add(lbDom);
        lbDom.setBounds(0, 0, 50, 20);

        add(pCalendario);
        pCalendario.setBounds(20, 110, 350, 20);

        pDia.setOpaque(false);
        add(pDia);
        pDia.setBounds(20, 140, 350, 260);

        lbMes.setFont(new java.awt.Font("Trebuchet MS", 0, 18));
        lbMes.setText(" Mês:");
        add(lbMes);
        lbMes.setBounds(200, 60, 170, 40);

        lbAno.setFont(new java.awt.Font("Trebuchet MS", 0, 18));
        lbAno.setText(" Ano:");
        add(lbAno);
        lbAno.setBounds(20, 60, 180, 40);

        /*lbTitulo.setFont(new java.awt.Font("Trebuchet MS", 0, 21));
        lbTitulo.setText(" Calendário:");
        add(lbTitulo);
        lbTitulo.setBounds(20, 20, 350, 30);*/

        sAno.setModel(new javax.swing.SpinnerNumberModel(d.getYear() + 1900, 1960, 2099, 1));
        sAno.setEditor(new JSpinner.NumberEditor(sAno, "###0"));
        sAno.setBounds(70, 70, 50, 20);
        sAno.setEditor(new JSpinner.NumberEditor(sAno, "####"));
        ChangeListener listener = (ChangeEvent e) -> {
            calendario();
        };
        sAno.addChangeListener(listener);
        add(sAno);
    }

    private void cbMesActionPerformed(java.awt.event.ActionEvent evt) {
        calendario();
    }

    private javax.swing.JComboBox cbMes;
    private javax.swing.JSpinner sAno;
    private javax.swing.JPanel pCalendario;
    public static javax.swing.JLabel lbAno;
    private javax.swing.JLabel lbDom;
    public static javax.swing.JLabel lbMes;
    private javax.swing.JLabel lbQua;
    private javax.swing.JLabel lbQui;
    private javax.swing.JLabel lbSab;
    private javax.swing.JLabel lbSeg;
    private javax.swing.JLabel lbSex;
    private javax.swing.JLabel lbTer;
    //public javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel pDia;
}
