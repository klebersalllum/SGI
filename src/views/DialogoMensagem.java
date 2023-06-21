package views;

import controllers.interfaces.Strings;

import javax.swing.*;

public class DialogoMensagem extends JDialog {
    private JPanel contentPane;
    private JButton btnOK;
    private JLabel lblMensagem;

    public DialogoMensagem(String mensagem) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnOK);
        setTitle(Strings.SGI);

        lblMensagem.setText(mensagem);
        btnOK.addActionListener(e -> dispose());
    }
}