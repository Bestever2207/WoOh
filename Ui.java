import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;


public class Ui {
    static JFrame frame; 
    JPanel statusLine;
    JPanel pixelRaster;
    static JLayeredPane panel;

    static JPanel panel_scrollArea;
    static JButton button;
    static Font font1 = new Font("Open Sans",Font.PLAIN, 26);
    static Font font2 = new Font("Open Sans",Font.PLAIN, 24);
    static ImageIcon logo_img = new ImageIcon("img/logo4.png");


    
    public static void start()
    {
        frame = new JFrame("WoOh");
        frame.setSize(1422,900);
        //frame.setIconImage();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground( Color.decode("#ffffff") );
        panel = new JLayeredPane();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        frame.add(panel);
        frame.setVisible(true);

    }
    
    public static void scrollPanel()
    {
        panel_scrollArea = new JPanel();
        frame.add(panel_scrollArea);
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

    public static JComponent[] mainScreen()
    {
        panel.removeAll();

        JComponent[] jComponent = new JComponent[8];

        JLabel obere_Leiste = new JLabel();
        obere_Leiste.setBackground(Color.decode("#D4AF37"));
        obere_Leiste.setBounds(0,0,1422,210);
        obere_Leiste.setOpaque(true);
        panel.add(obere_Leiste,1);

        logo_img.setImage(logo_img.getImage().getScaledInstance(160,160,Image.SCALE_SMOOTH));
        JLabel logo = new JLabel(logo_img);
        logo.setBackground(Color.decode("#D4AF37"));
        logo.setBounds(25,25,160,160);
        logo.setOpaque(true);
        panel.add(logo,0);

        JTextField gerichte_in = new JTextField();
        gerichte_in.setBounds(236,25,595,65);
        gerichte_in.setFont(font1);
        gerichte_in.setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff")));
        panel.add(gerichte_in,1);

        jComponent[0] = gerichte_in;

        JTextField restaurants_in = new JTextField();
        restaurants_in.setBounds(236,120,595,65);
        restaurants_in.setFont(font1);
        restaurants_in.setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff")));
        panel.add(restaurants_in,1);

        jComponent[1] = restaurants_in;

        ImageIcon search_icon = new ImageIcon("img/search-icon.png");
        search_icon.setImage(search_icon.getImage().getScaledInstance(65,65,Image.SCALE_SMOOTH));

        JButton suchen_btn_gericht = new JButton(search_icon);
        suchen_btn_gericht.setBackground(Color.decode("#ffffff"));
        suchen_btn_gericht.setBorder(null);
        suchen_btn_gericht.setBounds(831,25,65,65);

        panel.add(suchen_btn_gericht,1);

        jComponent[2] = suchen_btn_gericht;

        JButton suchen_btn_restaurant = new JButton(search_icon);
        suchen_btn_restaurant.setBackground(Color.decode("#ffffff"));
        suchen_btn_restaurant.setBorder(null);
        suchen_btn_restaurant.setBounds(831,120,65,65);
        panel.add(suchen_btn_restaurant,1);

        jComponent[3] = suchen_btn_restaurant;


        ImageIcon geld_icon = new ImageIcon("img/Dollarzeichen.png");
        geld_icon.setImage(geld_icon.getImage().getScaledInstance(65,65,Image.SCALE_SMOOTH));

        JButton geld = new JButton(geld_icon);
        geld.setBackground(Color.decode("#D4AF37"));
        geld.setBorder(null);
        geld.setBounds(998,73,65,65);
        panel.add(geld,0);

        jComponent[4] = geld;

        ImageIcon bestellhistorie_icon = new ImageIcon("img/Bestellhistorie.png");
        bestellhistorie_icon.setImage(bestellhistorie_icon.getImage().getScaledInstance(65,65,Image.SCALE_SMOOTH));

        JButton bestellhistorie = new JButton(bestellhistorie_icon);
        bestellhistorie.setBackground(Color.decode("#D4AF37"));
        bestellhistorie.setBorder(null);
        bestellhistorie.setBounds(1134,73,65,65);
        panel.add(bestellhistorie,0);

        jComponent[5] = bestellhistorie;


        ImageIcon warenkorb_icon = new ImageIcon("img/Warenkorb.png");
        warenkorb_icon.setImage(warenkorb_icon.getImage().getScaledInstance(65,65,Image.SCALE_SMOOTH));

        JButton warenkorb = new JButton(warenkorb_icon);
        warenkorb.setBackground(Color.decode("#D4AF37"));
        warenkorb.setBorder(null);
        warenkorb.setBounds(1270,73,65,65);
        panel.add(warenkorb,0);

        jComponent[6] = warenkorb;


        JLabel sortieren = new JLabel("Sortieren nach");
        sortieren.setFont(new Font("Open Sans",Font.PLAIN, 24));
        sortieren.setBounds(1050,238,187,40);
        panel.add(sortieren,0);

        String[] optionen = {"Preis","Dauer",""};
        JComboBox<String> jComboBox = new JComboBox<>(optionen);
        jComboBox.setFont(new Font("Open Sans",Font.PLAIN, 24));
        jComboBox.setForeground(Color.black);
        jComboBox.setBackground(Color.white);
        jComboBox.setBounds(1229, 234, 148, 47);
        panel.add(jComboBox,1);

        jComponent[7] = jComboBox;

        JPanel container = new JPanel();

        JButton btn1 = new JButton("1");
        btn1.setBackground(Color.decode("#D4AF37"));
        btn1.setBorder(null);
        btn1.setBounds(165,321,1092,187);
        container.add(btn1);

        JButton btn2 = new JButton("2");
        btn2.setBackground(Color.decode("#D4AF37"));
        btn2.setBorder(null);
        btn2.setBounds(165,532,1092,187);
        container.add(btn2);

        Box box = Box.createVerticalBox();
        box.add(btn1);
        JScrollPane scrollArea = new JScrollPane(box,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scrollArea.setBounds(152,305,1118,500);
        scrollArea.getViewport ().setView ( null );
        scrollArea.getViewport().setBackground(Color.decode("#ffffff"));
        scrollArea.setForeground(Color.decode("#ffffff"));
        scrollArea.setBorder(null);
        scrollArea.setVisible(true);



        panel.add(scrollArea);




        //JScrollPane scrollpane = new JScrollPane(container);
        panel.validate();
        panel.repaint();
        panel.revalidate();

        return jComponent;
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
    public static void scrollBox_erstellen()
    {

    }
    /*
    public static void suchenScreenFalsch()
    {

    }

     */
    public static void restaurantsAusgeben(Restaurant[] suchergebnisse,double[] lieferzeiten)
    {
        for(int i = 0;i < suchergebnisse.length;i++)
        {
            System.out.println(suchergebnisse[i].getName() + ": " + suchergebnisse[i].getGenre() + ", " + lieferzeiten[i] + ", " + suchergebnisse[i].getPreisspanne());
        }
    }
    public static void gerichteAusgeben(Datenelement[][][] suchergebnisse,double[] lieferzeiten)
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
