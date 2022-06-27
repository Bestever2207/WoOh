import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Ui {
    static JFrame frame; 
    JPanel statusLine;
    JPanel pixelRaster;
    static JLayeredPane panel;
    JLabel statusLabel;
    static JButton button;
    static Font font1 = new Font("Open Sans",Font.PLAIN, 26);
    static Font font2 = new Font("Open Sans",Font.PLAIN, 24);
    public static void start()
    {
        frame = new JFrame("WoOh");
        frame.setSize(1422,900);
        //frame.setIconImage();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground( Color.decode("#ffffff") );
        panel = new JLayeredPane();
        panel.setBackground(Color.WHITE);
        frame.add(panel);
        frame.setVisible(true);

    }
    
    
    
    
    
    
    public static JComponent[] KoordsScreen()
    {
        JComponent[] components = new JComponent[6];


        ImageIcon logo_img = new ImageIcon("img/logo4.png");
        logo_img.setImage(logo_img.getImage().getScaledInstance(169,169,Image.SCALE_SMOOTH));
        JLabel logo = new JLabel(logo_img);
        logo.setBounds(25,25,169,169);
        panel.add(logo);

        JTextField strasse_in = new JTextField();
        strasse_in.setBounds(458,228,381,69);
        strasse_in.setFont(font1);
        strasse_in.setBorder(BorderFactory.createLineBorder(Color.decode("#D4AF37")));

        panel.add(strasse_in);
        components[0] = strasse_in;

        JLabel strasse_tx = new JLabel("Straße");
        strasse_tx.setFont(font2);
        strasse_tx.setBounds(458,192,147,36);

        panel.add(strasse_tx);


        JTextField nummer_in = new JTextField();
        nummer_in.setBounds(862,228,101,69);
        nummer_in.setFont(font1);
        nummer_in.setBorder(BorderFactory.createLineBorder(Color.decode("#D4AF37")));

        panel.add(nummer_in);
        components[1] = nummer_in;

        JLabel nummer_tx = new JLabel("Nr.");
        nummer_tx.setFont(font2);
        nummer_tx.setBounds(862,192,101,36);

        panel.add(nummer_tx);


        JTextField stadt_in = new JTextField();
        stadt_in.setBounds(458,341,279,69);
        stadt_in.setFont(font1);
        stadt_in.setBorder(BorderFactory.createLineBorder(Color.decode("#D4AF37")));

        panel.add(stadt_in);
        components[2] = stadt_in;

        JLabel stadt_tx = new JLabel("Stadt");
        stadt_tx.setFont(font2);
        stadt_tx.setBounds(458,305,75,36);

        panel.add(stadt_tx);


        JTextField plz_in = new JTextField();
        plz_in.setBounds(795,341,168,69);
        plz_in.setFont(font1);
        plz_in.setBorder(BorderFactory.createLineBorder(Color.decode("#D4AF37")));

        panel.add(plz_in);
        components[3] = plz_in;

        JLabel plz_tx = new JLabel("PLZ");
        plz_tx.setFont(font2);
        plz_tx.setBounds(795,305,75,36);

        panel.add(plz_tx);


        JTextField name_in = new JTextField();
        name_in.setBounds(458,500,505,69);
        name_in.setFont(font1);
        name_in.setBorder(BorderFactory.createLineBorder(Color.decode("#D4AF37")));

        panel.add(name_in);
        components[4] = name_in;

        JLabel name_tx = new JLabel("Name");
        name_tx.setFont(font2);
        name_tx.setBounds(458,464,74,36);

        panel.add(name_tx);


        JButton suchen_btn = new JButton("Suchen");
        suchen_btn.setFont(new Font("Open Sans",Font.PLAIN, 32));
        suchen_btn.setBackground(Color.decode("#D4AF37"));
        suchen_btn.setBounds(571,624,279,83);

        panel.add(suchen_btn);
        components[5] = suchen_btn;


        panel.validate();
        panel.repaint();
        panel.revalidate();


        return components;
    }

    public static void koordsScreenFalsch()
    {
        System.out.println("Adresse nicht eindeutig! Achte darauf, dass alles richtig geschrieben und eine Hausnummer eingegeben wurde. Wiederholen sie den Vorgang.");
    }

    public static String mainScreen()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gebe eine der Folgenden Aktionen ein, um sie auszuführen");
        System.out.println("suchen - Gericht/Restaurant/Genre suchen");
        System.out.println("Bestellverlauf - zeigt bereits getätigte Bestellungen an");
        System.out.println("Warenkorb - zeigt alle Gerichte, welche bereits hinzugefügt wurden");
        System.out.println("Geld - zeigt dein aufgeladenes Geld + du kannst weiteres Geld aufladen");

        String input = scanner.nextLine();
        return input;
    }
    public static String[] suchenScreen()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Fülle nur eins der beiden Felder aus!");
        System.out.println("Gib deine gewünschte Essensrichtung oder ein Restaurant ein: ");
        String restaurant = scanner.nextLine();

        System.out.println("Gib dein gewünschtes Gericht ein: ");
        String gericht = scanner.nextLine();

        return new String[]{restaurant,gericht};
    }
    public static void suchenScreenFalsch()
    {
        System.out.println("Achte darauf in nur eins der beiden Felder etwas einzugeben");
    }
    public static void RestaurantsAusgeben(Restaurant[] suchergebnisse,double[] lieferzeiten)
    {
        for(int i = 0;i < suchergebnisse.length;i++)
        {
            System.out.println(suchergebnisse[i].getName() + ": " + suchergebnisse[i].getGenre() + ", " + lieferzeiten[i] + ", " + suchergebnisse[i].getPreisspanne());
        }
    }
    public static void GerichteAusgeben(Datenelement[][][] suchergebnisse,double[] lieferzeiten)
    {
        for(int r = 0;r < suchergebnisse.length;r++)
        {
            for(int s = 0;s < suchergebnisse[r][0].length;s++)
            {
                System.out.println(suchergebnisse[r][1][0].getName() + ": " + suchergebnisse[r][0][s].getName());
            }
        }
    }

    public static void KeineSuchergebnisse()
    {
        System.out.println("Keine passenden Angebote gefunden");
    }
    public static void bestellScreen()
    {

    }
    public static void Warenkorb()
    {

    }
    public static void Bestellhistorie()
    {

    }
    public static void Guthaben()
    {

    }
    public static void extra()
    {

    }

}
