package Produtos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Produtos {
    private JPanel JPanelPrincipal;
    private JTextField textFieldNome;
    private JTextField textFieldQuantidade;
    private JButton salvarButton;
    private JButton eliminarButton;
    private JButton atualizarButton;
    private JTextField textFieldId;
    private JButton pesquisarButton;
    private JTextField textFieldPreço;
    private JButton button1;

    public static void setVisible(boolean b) {
        JFrame frame = new JFrame("Gestao dos Produtos");
        frame.setContentPane(new Produtos().JPanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    Connection con;
    PreparedStatement pst;

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdprodutos", "root", "1234");
            System.out.println("Success");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Produtos() {
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
Connect();
                String nome, preço, quantidade;
                nome = textFieldNome.getText();
                preço = textFieldPreço.getText();
                quantidade = textFieldQuantidade.getText();
                try {
                    pst = con.prepareStatement("insert into produtos(nome,preco,quantidade)values(?,?,?)");
                    pst.setString(1, nome);
                    pst.setString(2, preço);
                    pst.setString(3, quantidade);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Addedddddd!!!!");
                    textFieldNome.setText("");
                    textFieldPreço.setText("");
                    textFieldQuantidade.setText("");
                    textFieldNome.requestFocus();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        });
        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connect();
                    String pid = textFieldId.getText();
                    pst = con.prepareStatement("select nome,preco,quantidade from produtos where id = ?");
                    pst.setString(1, pid);
                    ResultSet rs = pst.executeQuery();
                    if(rs.next()==true)
                    {
                        String nome = rs.getString(1);
                        String preço = rs.getString(2);
                        String quantidade = rs.getString(3);
                        textFieldNome.setText(nome);
                        textFieldPreço.setText(preço);
                        textFieldQuantidade.setText(quantidade);
                    }
                    else
                    {
                        textFieldQuantidade.setText("");
                        textFieldNome.setText("");
                        textFieldPreço.setText("");
                        JOptionPane.showMessageDialog(null,"Invalid Product ID");
                    }
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        });
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connect();
                String id,nome,preço,quantidade;
                nome = textFieldNome.getText();
                preço = textFieldPreço.getText();
                quantidade = textFieldQuantidade.getText();
                id = textFieldId.getText();
                try {
                    pst = con.prepareStatement("update produtos set nome = ?,preco = ?,quantidade = ? where id = ?");
                    pst.setString(1, nome);
                    pst.setString(2, preço);
                    pst.setString(3, quantidade);
                    pst.setString(4, id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Updateee!!!!!");
                    textFieldNome.setText("");
                    textFieldQuantidade.setText("");
                    textFieldPreço.setText("");
                    textFieldNome.requestFocus();
                    textFieldId.setText("");
                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connect();
                String bid;
                bid = textFieldId.getText();
                try {
                    pst = con.prepareStatement("delete from produtos where id = ?");
                    pst.setString(1, bid);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Deleteeeeee!!!!!");
                    textFieldNome.setText("");
                    textFieldPreço.setText("");
                    textFieldQuantidade.setText("");
                    textFieldNome.requestFocus();
                    textFieldId.setText("");
                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });

    }
}




