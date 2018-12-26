import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame {
    private Container cp;
    private JPanel jpbackgr = new JPanel(new GridLayout(4, 8, 0, 0));
    private JPanel jpjbtn = new JPanel(new GridLayout(1, 3, 0, 0));
    private JLabel jlbbackgr[] = new JLabel[32];
    private ImageIcon image[] = new ImageIcon[32];
    private String st [] = new String[32];
    private ImageIcon icon = new ImageIcon("象棋背面.png");
    private JButton jntn = new JButton("re");
    private int i =0;


    public MainFrame() {

        init();

    }


    public void init() {
        this.setBounds(150,50,1000,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        setResizable(false);

        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(jpbackgr,BorderLayout.NORTH);
        cp.add(jpjbtn,BorderLayout.CENTER);
        jpjbtn.add(jntn);

        for (int i = 0 ; i < 32 ; i ++){
            jlbbackgr[i] = new JLabel();
            jlbbackgr[i].setIcon(icon);
            jlbbackgr[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            jpbackgr.add(jlbbackgr[i]);


        }


            jntn.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Rand(st);
                }
            });
        }


    public void Rand (String arg[]){
        Random rnd = new Random(System.currentTimeMillis());
        int i = 0 ;
        while (i < 32){
            arg[i] = Integer.toString(rnd.nextInt(32));
            image[i] = new ImageIcon(arg[i] + ".png");
            jlbbackgr[i].setIcon(image[i]);
            int j = 0 ;
            boolean flag = false;
            while (j < i){
                if (arg[i].equals(arg[j])){
                    flag = true;
                    j = i;
                }
                j ++;
            }
            if (!flag){
                i ++;
            }
        }
    }
}
