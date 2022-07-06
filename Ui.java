import java.awt.*;
import javax.swing.*;


public class Ui {
    static JFrame FRAME;

    static JLayeredPane PANEL;

    static Font FONT1 = new Font("Open Sans",Font.PLAIN, 26);
    static Font FONT2 = new Font("Open Sans",Font.PLAIN, 24);
    static ImageIcon LOGO_IMG = new ImageIcon("img/logo4.png");
    static JScrollPane SCROLLPANE;
    static JPanel SCROLLPANE_INHALT;
    
    public static void start()
    {
        FRAME = new JFrame("WoOh");
        FRAME.setSize(1422,900);
        //frame.setIconImage();
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FRAME.getContentPane().setBackground( Color.decode("#ffffff") );
        PANEL = new JLayeredPane();
        PANEL.setLayout(null);
        PANEL.setBackground(Color.WHITE);
        FRAME.add(PANEL);
        FRAME.setVisible(true);

    }
    
    public static JComponent[] KoordsScreen()
    {
        JComponent[] components = new JComponent[6];


        ImageIcon logo_img = new ImageIcon("img/logo4.png");
        logo_img.setImage(logo_img.getImage().getScaledInstance(169,169,Image.SCALE_SMOOTH));
        JLabel logo = new JLabel(logo_img);
        logo.setBounds(25,25,169,169);
        PANEL.add(logo);

        JTextField strasse_in = new JTextField("Düsseldorfer Str");
        strasse_in.setBounds(458,228,381,69);
        strasse_in.setFont(FONT1);
        strasse_in.setBorder(BorderFactory.createLineBorder(Color.decode("#D4AF37")));

        PANEL.add(strasse_in);
        components[0] = strasse_in;

        JLabel strasse_tx = new JLabel("Straße");
        strasse_tx.setFont(FONT2);
        strasse_tx.setBounds(458,192,147,36);

        PANEL.add(strasse_tx);


        JTextField nummer_in = new JTextField("17");
        nummer_in.setBounds(862,228,101,69);
        nummer_in.setFont(FONT1);
        nummer_in.setBorder(BorderFactory.createLineBorder(Color.decode("#D4AF37")));

        PANEL.add(nummer_in);
        components[1] = nummer_in;

        JLabel nummer_tx = new JLabel("Nr.");
        nummer_tx.setFont(FONT2);
        nummer_tx.setBounds(862,192,101,36);

        PANEL.add(nummer_tx);


        JTextField stadt_in = new JTextField("Nürnberg");
        stadt_in.setBounds(458,341,279,69);
        stadt_in.setFont(FONT1);
        stadt_in.setBorder(BorderFactory.createLineBorder(Color.decode("#D4AF37")));

        PANEL.add(stadt_in);
        components[2] = stadt_in;

        JLabel stadt_tx = new JLabel("Stadt");
        stadt_tx.setFont(FONT2);
        stadt_tx.setBounds(458,305,75,36);

        PANEL.add(stadt_tx);


        JTextField plz_in = new JTextField("90425");
        plz_in.setBounds(795,341,168,69);
        plz_in.setFont(FONT1);
        plz_in.setBorder(BorderFactory.createLineBorder(Color.decode("#D4AF37")));

        PANEL.add(plz_in);
        components[3] = plz_in;

        JLabel plz_tx = new JLabel("PLZ");
        plz_tx.setFont(FONT2);
        plz_tx.setBounds(795,305,75,36);

        PANEL.add(plz_tx);


        JTextField name_in = new JTextField("Lucas Horn");
        name_in.setBounds(458,500,505,69);
        name_in.setFont(FONT1);
        name_in.setBorder(BorderFactory.createLineBorder(Color.decode("#D4AF37")));

        PANEL.add(name_in);
        components[4] = name_in;

        JLabel name_tx = new JLabel("Name");
        name_tx.setFont(FONT2);
        name_tx.setBounds(458,464,74,36);

        PANEL.add(name_tx);


        JButton suchen_btn = new JButton("Suchen");
        suchen_btn.setFont(new Font("Open Sans",Font.PLAIN, 32));
        suchen_btn.setBackground(Color.decode("#D4AF37"));
        suchen_btn.setBounds(571,624,279,83);

        PANEL.add(suchen_btn);
        components[5] = suchen_btn;


        PANEL.validate();
        PANEL.repaint();
        PANEL.revalidate();


        return components;
    }

    public static void koordsScreenFalsch(JComponent[] userDaten_falsch)
    {
        for(int i = 0;i < 4;i++)
        {
            userDaten_falsch[i].setBorder(BorderFactory.createLineBorder(Color.decode("#ff0000")));
        }

        JLabel label_falsch = new JLabel("Achte darauf dass die Adresse eindeutig und jedes Feld ausgefüllt ist!",SwingConstants.CENTER);
        label_falsch.setBounds(298,784,826,53);
        label_falsch.setFont(FONT1);
        label_falsch.setBorder(BorderFactory.createLineBorder(Color.decode("#D4AF37")));
        label_falsch.setVisible(true);
        label_falsch.setHorizontalAlignment(SwingConstants.CENTER);

        JLayeredPane panel_falsch = new JLayeredPane();

        panel_falsch.setLayout(null);
        panel_falsch.setBackground(Color.BLACK);

        panel_falsch.add(label_falsch);
        panel_falsch.setVisible(true);
        //panel_falsch.setPreferredSize(new Dimension(826,53));

        FRAME.add(panel_falsch);

        PANEL.validate();
        PANEL.repaint();
        PANEL.revalidate();
       /* JPanel panel_falsch = new JPanel();
        
        panel_falsch.setLayout(null);
        panel_falsch.setBackground(Color.WHITE);
        
        JLabel label_falsch = new JLabel("<html>Achte darauf dass<br>die Adresse eindeutig <br>und jedes Feld ausgefüllt ist<html>");
        label_falsch.setBounds(800,400,200,200);
        label_falsch.setFont(FONT1);
        label_falsch.setBorder(BorderFactory.createLineBorder(Color.decode("#D4AF37")));
        label_falsch.setVisible(true);

        panel_falsch.setLayout(new BorderLayout());
        panel_falsch.add(label_falsch,BorderLayout.EAST);
        panel_falsch.setVisible(true);
        
        panel_falsch.validate();
        panel_falsch.repaint();
        panel_falsch.revalidate();
        
        PANEL.add(panel_falsch);
        
        
        PANEL.validate();
        PANEL.repaint();
        PANEL.revalidate();*/
    }

    public static JComponent[] mainScreen()
    {
        PANEL.removeAll();

        JComponent[] jComponent = new JComponent[8];

        JLabel obere_Leiste = new JLabel();
        obere_Leiste.setBackground(Color.decode("#D4AF37"));
        obere_Leiste.setBounds(0,0,1422,210);
        obere_Leiste.setOpaque(true);
        PANEL.add(obere_Leiste,1);

        LOGO_IMG.setImage(LOGO_IMG.getImage().getScaledInstance(160,160,Image.SCALE_SMOOTH));
        JLabel logo = new JLabel(LOGO_IMG);
        logo.setBackground(Color.decode("#D4AF37"));
        logo.setBounds(25,25,160,160);
        logo.setOpaque(true);
        PANEL.add(logo,0);

        JTextField gerichte_in = new JTextField();
        gerichte_in.setBounds(236,25,595,65);
        gerichte_in.setFont(FONT1);
        gerichte_in.setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff")));
        PANEL.add(gerichte_in,1);

        jComponent[0] = gerichte_in;

        JTextField restaurants_in = new JTextField();
        restaurants_in.setBounds(236,120,595,65);
        restaurants_in.setFont(FONT1);
        restaurants_in.setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff")));
        PANEL.add(restaurants_in,1);

        jComponent[1] = restaurants_in;

        ImageIcon search_icon = new ImageIcon("img/search-icon.png");
        search_icon.setImage(search_icon.getImage().getScaledInstance(65,65,Image.SCALE_SMOOTH));

        JButton suchen_btn_gericht = new JButton(search_icon);
        suchen_btn_gericht.setBackground(Color.decode("#ffffff"));
        suchen_btn_gericht.setBorder(null);
        suchen_btn_gericht.setBounds(831,25,65,65);

        PANEL.add(suchen_btn_gericht,1);

        jComponent[2] = suchen_btn_gericht;

        JButton suchen_btn_restaurant = new JButton(search_icon);
        suchen_btn_restaurant.setBackground(Color.decode("#ffffff"));
        suchen_btn_restaurant.setBorder(null);
        suchen_btn_restaurant.setBounds(831,120,65,65);
        PANEL.add(suchen_btn_restaurant,1);

        jComponent[3] = suchen_btn_restaurant;


        ImageIcon geld_icon = new ImageIcon("img/Dollarzeichen.png");
        geld_icon.setImage(geld_icon.getImage().getScaledInstance(65,65,Image.SCALE_SMOOTH));

        JButton geld = new JButton(geld_icon);
        geld.setBackground(Color.decode("#D4AF37"));
        geld.setBorder(null);
        geld.setBounds(998,73,65,65);
        PANEL.add(geld,0);

        jComponent[4] = geld;

        ImageIcon bestellhistorie_icon = new ImageIcon("img/Bestellhistorie.png");
        bestellhistorie_icon.setImage(bestellhistorie_icon.getImage().getScaledInstance(65,65,Image.SCALE_SMOOTH));

        JButton bestellhistorie = new JButton(bestellhistorie_icon);
        bestellhistorie.setBackground(Color.decode("#D4AF37"));
        bestellhistorie.setBorder(null);
        bestellhistorie.setBounds(1134,73,65,65);
        PANEL.add(bestellhistorie,0);

        jComponent[5] = bestellhistorie;


        ImageIcon warenkorb_icon = new ImageIcon("img/shoppingCart.png");
        warenkorb_icon.setImage(warenkorb_icon.getImage().getScaledInstance(65,65,Image.SCALE_SMOOTH));

        JButton warenkorb = new JButton(warenkorb_icon);
        warenkorb.setBackground(Color.decode("#D4AF37"));
        warenkorb.setBorder(null);
        warenkorb.setBounds(1270,73,65,65);
        PANEL.add(warenkorb,0);

        jComponent[6] = warenkorb;


        JLabel sortieren = new JLabel("Sortieren nach");
        sortieren.setFont(new Font("Open Sans",Font.PLAIN, 24));
        sortieren.setBounds(1050,238,187,40);
        PANEL.add(sortieren,0);

        String[] optionen = {"","Preis","Dauer"};
        JComboBox<String> jComboBox = new JComboBox<>(optionen);
        jComboBox.setFont(new Font("Open Sans",Font.PLAIN, 24));
        jComboBox.setForeground(Color.black);
        jComboBox.setBackground(Color.white);
        jComboBox.setBounds(1229, 234, 148, 47);
        PANEL.add(jComboBox,1);

        jComponent[7] = jComboBox;



        //JScrollPane scrollpane = new JScrollPane(container);
        PANEL.validate();
        PANEL.repaint();
        PANEL.revalidate();

        return jComponent;
    }



    public static void scrollpane_erstellen(int height)
    {

        if(SCROLLPANE != null) {
            System.out.println(SCROLLPANE_INHALT.getComponents().length);
            SCROLLPANE_INHALT.removeAll();
            System.out.println(SCROLLPANE_INHALT.getComponents().length);
        }


        SCROLLPANE_INHALT = new JPanel();

        BoxLayout bl = new BoxLayout(SCROLLPANE_INHALT, BoxLayout.Y_AXIS);
        SCROLLPANE_INHALT.setPreferredSize(new Dimension(1133, height));
        SCROLLPANE_INHALT.setLayout(bl);
        SCROLLPANE_INHALT.setBackground(Color.decode("#ffffff"));
        SCROLLPANE_INHALT.setVisible(true);


        if(SCROLLPANE == null)
        {
            SCROLLPANE = new JScrollPane(SCROLLPANE_INHALT, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            SCROLLPANE.setBounds(152, 305, 1133, Math.min(height, 500));
            SCROLLPANE.getViewport().setBackground(Color.decode("#ffffff"));
            SCROLLPANE.setForeground(Color.decode("#ffffff"));
            SCROLLPANE.setBorder(null);
            SCROLLPANE.setVisible(true);
            SCROLLPANE.getVerticalScrollBar().setUnitIncrement(10);
            SCROLLPANE.getVerticalScrollBar().setBackground(Color.WHITE);


            PANEL.add(SCROLLPANE);
            return;
        }
        SCROLLPANE.setViewportView(SCROLLPANE_INHALT);
    }

    public static JComponent[] restaurantsAusgeben(Restaurant[] suchergebnisse,double[] lieferzeiten)
    {
        int anzahl_suchergebnisse = suchergebnisse.length;
        int height = 15 + anzahl_suchergebnisse * (15 + 187);

        JComponent[] components = new JComponent[anzahl_suchergebnisse];

        scrollpane_erstellen(height);

        System.out.println("restaurantsAusgeben ausgeführt");



        for(int i = 0;i < suchergebnisse.length;i++)
        {
            JLayeredPane btn_panel = new JLayeredPane();

            JButton btn = new JButton();

            btn.setBackground(Color.decode("#ffffff"));
            btn.setBounds(15,15,1088,187);
            btn.setAlignmentX(JButton.CENTER_ALIGNMENT);
            btn.setVisible(true);
            btn.setBorder(BorderFactory.createLineBorder(Color.decode("#D4AF37")));

            JLabel name = new JLabel(suchergebnisse[i].getName());
            name.setFont(new Font("Open Sans",Font.PLAIN, 32));
            name.setBounds(35,35,901,41);

            JLabel essensrichtung = new JLabel(suchergebnisse[i].getGenre());
            essensrichtung.setFont(new Font("Open Sans",Font.PLAIN, 24));
            essensrichtung.setBounds(35,94,901,18);

            ImageIcon einkaufstasche_icon = new ImageIcon("img/Einkaufstasche.png");
            einkaufstasche_icon.setImage(einkaufstasche_icon.getImage().getScaledInstance(41,41,Image.SCALE_SMOOTH));

            JLabel einkaufstasche = new JLabel(einkaufstasche_icon);
            einkaufstasche.setBounds(893,35,41,41);
            einkaufstasche.setBackground(Color.decode("#D4AF37"));

            JLabel preis = new JLabel("" + suchergebnisse[i].getPreisspanne() + "€");
            preis.setBounds(963,35,129,41);
            preis.setFont(new Font("Open Sans",Font.PLAIN, 32));
            preis.setBackground(Color.decode("#ffffff"));

            ImageIcon zeit_icon = new ImageIcon("img/zeit.png");
            zeit_icon.setImage(zeit_icon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH));

            JLabel zeit = new JLabel(zeit_icon);
            zeit.setBounds(27,131,40,40);
            zeit.setBackground(Color.decode("#ffffff"));


            JLabel durchschnittszeit = new JLabel("ca." + Math.round(lieferzeiten[i]) + " min");
            durchschnittszeit.setBounds(82,139,901,24);
            durchschnittszeit.setBackground(Color.decode("#ffffff"));
            durchschnittszeit.setFont(new Font("Open Sans",Font.PLAIN, 24));


            btn_panel.add(name,JLayeredPane.PALETTE_LAYER);
            btn_panel.add(essensrichtung,JLayeredPane.PALETTE_LAYER);

            btn_panel.add(einkaufstasche,JLayeredPane.PALETTE_LAYER);
            btn_panel.add(preis,JLayeredPane.PALETTE_LAYER);

            btn_panel.add(zeit,JLayeredPane.PALETTE_LAYER);
            btn_panel.add(durchschnittszeit,JLayeredPane.PALETTE_LAYER);

            btn_panel.add(btn,JLayeredPane.DEFAULT_LAYER);
            btn_panel.setVisible(true);

            components[i] = btn;

            SCROLLPANE_INHALT.add(btn_panel);

            System.out.println(SCROLLPANE_INHALT);
        }
        /*SCROLLPANE_INHALT.setVisible(true);
        SCROLLPANE_INHALT.validate();
        SCROLLPANE_INHALT.repaint();
        SCROLLPANE_INHALT.revalidate();

        System.out.println(SCROLLPANE_INHALT);

        SCROLLPANE.setVisible(true);
        SCROLLPANE.validate();
        SCROLLPANE.repaint();
        SCROLLPANE.revalidate();

        PANEL.validate();
        PANEL.repaint();
        PANEL.revalidate();*/
        return components;
    }

    public static JComponent[] gerichteAusgeben(Datenelement[][][] suchergebnisse,int[] lieferzeiten,boolean activ_btn)
    {
        int anzahl_suchergebnisse = lieferzeiten.length;

        int height = 15 + anzahl_suchergebnisse * (15 + 187);

        scrollpane_erstellen(height);
        JComponent[] components;

        if(activ_btn) {
            components = new JComponent[anzahl_suchergebnisse * 2];
        }
        else {
            components = new JComponent[anzahl_suchergebnisse];
        }

        System.out.println("restaurantsAusgeben ausgeführt");

        int index = 0;

        for(int r = 0;r < suchergebnisse.length;r++)
        {
            for(int s = 0;s < suchergebnisse[r][0].length;s++)
            {
                JLayeredPane btn_panel = new JLayeredPane();

                if(activ_btn) {
                    JButton btn = new JButton();
                    btn.setBackground(Color.decode("#ffffff"));
                    btn.setBounds(15,15,1088,187);
                    btn.setAlignmentX(JButton.CENTER_ALIGNMENT);
                    btn.setVisible(true);
                    btn.setBorder(BorderFactory.createLineBorder(Color.decode("#D4AF37")));
                    btn_panel.add(btn,JLayeredPane.DEFAULT_LAYER);

                    components[index] = btn;
                    index++;
                }
                else {

                    JLabel btn = new JLabel();
                    btn.setBackground(Color.decode("#ffffff"));
                    btn.setBounds(15, 15, 1088, 187);
                    btn.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                    btn.setVisible(true);
                    btn.setBorder(BorderFactory.createLineBorder(Color.decode("#D4AF37")));
                    btn_panel.add(btn,JLayeredPane.DEFAULT_LAYER);
                }

                JLabel name = new JLabel(suchergebnisse[r][0][s].getName());
                name.setFont(new Font("Open Sans",Font.PLAIN, 32));
                name.setBounds(35,35,901,41);

                String[] beilagen = suchergebnisse[r][0][s].getBeilagen();
                String alle_beilagen = "Beilagen: " + beilagen[0];

                for(int i = 0;i < beilagen.length;i++)
                {
                    alle_beilagen = alle_beilagen + ", " + beilagen[i];
                }
                JLabel beilagen_label = new JLabel(alle_beilagen);
                beilagen_label.setFont(new Font("Open Sans",Font.PLAIN, 24));
                beilagen_label.setBounds(35,88,901,30);

                ImageIcon einkaufstasche_icon = new ImageIcon("img/Einkaufstasche.png");
                einkaufstasche_icon.setImage(einkaufstasche_icon.getImage().getScaledInstance(41,41,Image.SCALE_SMOOTH));

                JLabel einkaufstasche = new JLabel(einkaufstasche_icon);
                einkaufstasche.setBounds(893,35,41,41);
                einkaufstasche.setBackground(Color.decode("#D4AF37"));

                JLabel preis = new JLabel("" + suchergebnisse[r][0][s].preisGeben() + "€");
                preis.setBounds(963,35,129,41);
                preis.setFont(new Font("Open Sans",Font.PLAIN, 32));
                preis.setBackground(Color.decode("#ffffff"));

                ImageIcon zeit_icon = new ImageIcon("img/zeit.png");
                zeit_icon.setImage(zeit_icon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH));

                JLabel zeit = new JLabel(zeit_icon);
                zeit.setBounds(27,131,40,40);
                zeit.setBackground(Color.decode("#ffffff"));


                JLabel durchschnittszeit = new JLabel("ca." + Math.round(lieferzeiten[Math.round(index/2)]) + " min" + "     " + "\t" + suchergebnisse[r][1][0].getName());
                durchschnittszeit.setBounds(82,131,1000,40);
                durchschnittszeit.setBackground(Color.decode("#ffffff"));
                durchschnittszeit.setFont(new Font("Open Sans",Font.PLAIN, 24));

                ImageIcon plus_icon = new ImageIcon("img/plus.png");
                plus_icon.setImage(plus_icon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH));

                JButton plus = new JButton(plus_icon);
                plus.setBounds(1068,10,40,40);
                plus.setBackground(Color.decode("#ffffff"));

                components[index] = plus;

                btn_panel.add(name,JLayeredPane.PALETTE_LAYER);
                btn_panel.add(beilagen_label,JLayeredPane.PALETTE_LAYER);
                btn_panel.add(einkaufstasche,JLayeredPane.PALETTE_LAYER);
                btn_panel.add(preis,JLayeredPane.PALETTE_LAYER);

                btn_panel.add(zeit,JLayeredPane.PALETTE_LAYER);
                btn_panel.add(durchschnittszeit,JLayeredPane.PALETTE_LAYER);
                btn_panel.add(plus,JLayeredPane.PALETTE_LAYER);

                btn_panel.setVisible(true);

                System.out.println("Gericht wird erstellt");
                SCROLLPANE_INHALT.add(btn_panel);

                //System.out.println(SCROLLPANE_INHALT.getComponent(0));

                SCROLLPANE_INHALT.validate();
                SCROLLPANE_INHALT.repaint();
                SCROLLPANE_INHALT.revalidate();
                index++;
            }
        }
        /*SCROLLPANE_INHALT.validate();
        SCROLLPANE_INHALT.repaint();
        SCROLLPANE_INHALT.revalidate();*/

        //System.out.println(SCROLLPANE_INHALT.getComponent(0));
        //System.out.println(SCROLLPANE_INHALT.getComponent(1));
        //System.out.println(SCROLLPANE_INHALT.getComponent(2));

        /*SCROLLPANE.validate();
        SCROLLPANE.repaint();
        SCROLLPANE.revalidate();

        PANEL.validate();
        PANEL.repaint();
        PANEL.revalidate();

        FRAME.validate();
        FRAME.repaint();
        FRAME.revalidate();*/

        return components;
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
