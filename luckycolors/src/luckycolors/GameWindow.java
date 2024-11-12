package luckycolors;

import java.awt.Color;
import java.util.HashSet;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GameWindow extends javax.swing.JFrame {
//Variables 
    private Stack<String>[] viales;
    private int selectedVial = -1;
    private Border border = BorderFactory.createLineBorder(Color.GRAY, 5);
    private int dificulty;

//Array con JPanels para tener acceso individual
    public static JPanel[] vialPanels1;
    public static JPanel[] vialPanels2;
    public static JPanel[] vialPanels3;
    public static JPanel[] vialPanels4;
    public static JPanel[] vialPanels5;
    
//Metodos
    public GameWindow() {
        initComponents();
    }   

    //Inicia el juego, Acorde a la dificultad llena y oculta los viales necesarios
    public GameWindow(Stack<String>[] viales, int dificulty) {
        this.dificulty = dificulty;
        this.viales = viales;
        initComponents();
        
        switch (dificulty) {
            case 3 -> {
                paintViales(vialPanels1, 1);
                paintViales(vialPanels2, 2);
                paintViales(vialPanels3, 3);
                Vial4.setVisible(false);
                Vial5.setVisible(false);
            }
            case 4 -> {
                paintViales(vialPanels1, 1);
                paintViales(vialPanels2, 2);
                paintViales(vialPanels3, 3);
                paintViales(vialPanels4, 4);
                Vial5.setVisible(false);
            }
            case 5 -> {
                paintViales(vialPanels1, 1);
                paintViales(vialPanels2, 2);
                paintViales(vialPanels3, 3);
                paintViales(vialPanels4, 4);
                paintViales(vialPanels5, 5);
            }

        }
    }
    
    //Traductor de String a Color
    private Color getColor(String color) {
        if (color == null) {
            return Color.GRAY;
        } else if (color.equals("red")) {
            return Color.RED;
        } else if (color.equals("blue")) {
            return Color.BLUE;
        } else if (color.equals("yellow")) {
            return Color.YELLOW;
        } else if (color.equals("green")) {
            return Color.GREEN;
        } else if (color.equals("orange")) {
            return Color.ORANGE;
        } else {
            return Color.WHITE;
        }
    }

    //Obtiene los strings de cada vial, las traduce y pinta
    private void paintViales(JPanel[] vialPanel, int numVial) {
        for (int i = 0; i < vialPanel.length; i++) {
            //Separating null from strings
            String color = (i <= viales[numVial - 1].tope) ? viales[numVial - 1].getColorAt(i) : null; 
            Color c = getColor(color); 
            vialPanel[i].setBackground(c);
        }

    }

    //Actualiza los colores de los paneles acorde a su dificultad
    private void uptadeVialPanels(int dificulty, JPanel[] vialPanels1, JPanel[] vialPanels2, JPanel[] vialPanels3, JPanel[] vialPanels4, JPanel[] vialPanels5) {
        switch (dificulty) {
            case 3 -> {
                paintViales(vialPanels1, 1);
                paintViales(vialPanels2, 2);
                paintViales(vialPanels3, 3);
            }
            case 4 -> {
                paintViales(vialPanels1, 1);
                paintViales(vialPanels2, 2);
                paintViales(vialPanels3, 3);
                paintViales(vialPanels4, 4);
            }
            case 5 -> {
                paintViales(vialPanels1, 1);
                paintViales(vialPanels2, 2);
                paintViales(vialPanels3, 3);
                paintViales(vialPanels4, 4);
                paintViales(vialPanels5, 5);
            }

        }
;
    }

    //Aplica un reset a los bordes
    private void quitBorders() {
        Vial1.setBorder(null);
        Vial2.setBorder(null);
        Vial3.setBorder(null);
        Vial4.setBorder(null);
        Vial5.setBorder(null);
    }

    //Cambia el color
    private void changeColor(int fromVial, int toVial) {
        //Actualiza el indice para trabajar con arrays
        fromVial = fromVial - 1; 
        toVial = toVial - 1; 

        //edgecase 1
        if (viales[fromVial].isEmpty()) {
            System.out.println("No color to move.");
            return; 
        }
        String colorToMove = viales[fromVial].pop(); 

        //edgecase 2
        if(viales[toVial].isFull()){
            System.out.println("Stack is already full");
            viales[fromVial].push(colorToMove);
            return;
        }else{
        //Traslado
            viales[toVial].push(colorToMove);
        }
        uptadeVialPanels(dificulty, vialPanels1, vialPanels2, vialPanels3, vialPanels4, vialPanels5);
        
    }
    

    private void handleVialClick(int vialNumber) {
        if (selectedVial == -1) {
            // Inicializa el vial a usar 
            selectedVial = vialNumber;  
            System.out.println("Selected source vial: " + selectedVial);
        } else {
            // Obtiene el segundo vial
            int toVial = vialNumber;  
            System.out.println("Selected destination vial: " + toVial);  
            //Traslado
            changeColor(selectedVial, toVial);          
            //Reset   
            selectedVial = -1;
        }
          checkIfWon();
    }

    private void initComponents() {


        Vial1 = new javax.swing.JLayeredPane();
        Color4P1 = new javax.swing.JPanel();
        Color3P1 = new javax.swing.JPanel();
        Color2P1 = new javax.swing.JPanel();
        Color1P1 = new javax.swing.JPanel();
        Vial2 = new javax.swing.JLayeredPane();
        Color4P2 = new javax.swing.JPanel();
        Color3P2 = new javax.swing.JPanel();
        Color2P2 = new javax.swing.JPanel();
        Color1P2 = new javax.swing.JPanel();
        Vial3 = new javax.swing.JLayeredPane();
        Color4P3 = new javax.swing.JPanel();
        Color3P3 = new javax.swing.JPanel();
        Color2P3 = new javax.swing.JPanel();
        Color1P3 = new javax.swing.JPanel();
        Vial4 = new javax.swing.JLayeredPane();
        Color4P4 = new javax.swing.JPanel();
        Color3P4 = new javax.swing.JPanel();
        Color2P4 = new javax.swing.JPanel();
        Color1P4 = new javax.swing.JPanel();
        Vial5 = new javax.swing.JLayeredPane();
        Color4P5 = new javax.swing.JPanel();
        Color3P5 = new javax.swing.JPanel();
        Color2P5 = new javax.swing.JPanel();
        Color1P5 = new javax.swing.JPanel();

        vialPanels1 = new JPanel[]{Color1P1, Color2P1, Color3P1, Color4P1};
        vialPanels2 = new JPanel[]{Color1P2, Color2P2, Color3P2, Color4P2};
        vialPanels3 = new JPanel[]{Color1P3, Color2P3, Color3P3, Color4P3};
        vialPanels4 = new JPanel[]{Color1P4, Color2P4, Color3P4, Color4P4};
        vialPanels5 = new JPanel[]{Color1P5, Color2P5, Color3P5, Color4P5};

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Vial1.setBackground(new java.awt.Color(102, 102, 102));
        Vial1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Vial1MouseClicked(evt);
            }
        });

        Color4P1.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout Color4P1Layout = new javax.swing.GroupLayout(Color4P1);
        Color4P1.setLayout(Color4P1Layout);
        Color4P1Layout.setHorizontalGroup(
            Color4P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color4P1Layout.setVerticalGroup(
            Color4P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Color3P1.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout Color3P1Layout = new javax.swing.GroupLayout(Color3P1);
        Color3P1.setLayout(Color3P1Layout);
        Color3P1Layout.setHorizontalGroup(
            Color3P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color3P1Layout.setVerticalGroup(
            Color3P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Color2P1Layout = new javax.swing.GroupLayout(Color2P1);
        Color2P1.setLayout(Color2P1Layout);
        Color2P1Layout.setHorizontalGroup(
            Color2P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color2P1Layout.setVerticalGroup(
            Color2P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Color1P1.setBackground(new java.awt.Color(0, 204, 0));

        javax.swing.GroupLayout Color1P1Layout = new javax.swing.GroupLayout(Color1P1);
        Color1P1.setLayout(Color1P1Layout);
        Color1P1Layout.setHorizontalGroup(
            Color1P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color1P1Layout.setVerticalGroup(
            Color1P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Vial1.setLayer(Color4P1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Vial1.setLayer(Color3P1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Vial1.setLayer(Color2P1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Vial1.setLayer(Color1P1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Vial1Layout = new javax.swing.GroupLayout(Vial1);
        Vial1.setLayout(Vial1Layout);
        Vial1Layout.setHorizontalGroup(
            Vial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Vial1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(Vial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Color1P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Color2P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Color3P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Color4P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        Vial1Layout.setVerticalGroup(
            Vial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Vial1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(Color4P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Color3P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Color2P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Color1P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Vial2.setBackground(new java.awt.Color(102, 102, 102));
        Vial2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Vial2MouseClicked(evt);
            }
        });

        Color4P2.setBackground(new java.awt.Color(255, 255, 0));
        Color4P2.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout Color4P2Layout = new javax.swing.GroupLayout(Color4P2);
        Color4P2.setLayout(Color4P2Layout);
        Color4P2Layout.setHorizontalGroup(
            Color4P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Color4P2Layout.setVerticalGroup(
            Color4P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Color3P2.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout Color3P2Layout = new javax.swing.GroupLayout(Color3P2);
        Color3P2.setLayout(Color3P2Layout);
        Color3P2Layout.setHorizontalGroup(
            Color3P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color3P2Layout.setVerticalGroup(
            Color3P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Color2P2Layout = new javax.swing.GroupLayout(Color2P2);
        Color2P2.setLayout(Color2P2Layout);
        Color2P2Layout.setHorizontalGroup(
            Color2P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color2P2Layout.setVerticalGroup(
            Color2P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Color1P2.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout Color1P2Layout = new javax.swing.GroupLayout(Color1P2);
        Color1P2.setLayout(Color1P2Layout);
        Color1P2Layout.setHorizontalGroup(
            Color1P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color1P2Layout.setVerticalGroup(
            Color1P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Vial2.setLayer(Color4P2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Vial2.setLayer(Color3P2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Vial2.setLayer(Color2P2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Vial2.setLayer(Color1P2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Vial2Layout = new javax.swing.GroupLayout(Vial2);
        Vial2.setLayout(Vial2Layout);
        Vial2Layout.setHorizontalGroup(
            Vial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Vial2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(Vial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Color1P2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Color2P2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Color3P2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Color4P2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        Vial2Layout.setVerticalGroup(
            Vial2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Vial2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(Color4P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Color3P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Color2P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Color1P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Vial3.setBackground(new java.awt.Color(102, 102, 102));
        Vial3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Vial3MouseClicked(evt);
            }
        });

        Color4P3.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout Color4P3Layout = new javax.swing.GroupLayout(Color4P3);
        Color4P3.setLayout(Color4P3Layout);
        Color4P3Layout.setHorizontalGroup(
            Color4P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color4P3Layout.setVerticalGroup(
            Color4P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Color3P3Layout = new javax.swing.GroupLayout(Color3P3);
        Color3P3.setLayout(Color3P3Layout);
        Color3P3Layout.setHorizontalGroup(
            Color3P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color3P3Layout.setVerticalGroup(
            Color3P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Color2P3Layout = new javax.swing.GroupLayout(Color2P3);
        Color2P3.setLayout(Color2P3Layout);
        Color2P3Layout.setHorizontalGroup(
            Color2P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color2P3Layout.setVerticalGroup(
            Color2P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Color1P3.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout Color1P3Layout = new javax.swing.GroupLayout(Color1P3);
        Color1P3.setLayout(Color1P3Layout);
        Color1P3Layout.setHorizontalGroup(
            Color1P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color1P3Layout.setVerticalGroup(
            Color1P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Vial3.setLayer(Color4P3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Vial3.setLayer(Color3P3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Vial3.setLayer(Color2P3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Vial3.setLayer(Color1P3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Vial3Layout = new javax.swing.GroupLayout(Vial3);
        Vial3.setLayout(Vial3Layout);
        Vial3Layout.setHorizontalGroup(
            Vial3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Vial3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(Vial3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Color1P3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Color2P3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Color3P3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Color4P3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        Vial3Layout.setVerticalGroup(
            Vial3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Vial3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(Color4P3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Color3P3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Color2P3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Color1P3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Vial4.setBackground(new java.awt.Color(102, 102, 102));
        Vial4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Vial4MouseClicked(evt);
            }
        });

        Color4P4.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout Color4P4Layout = new javax.swing.GroupLayout(Color4P4);
        Color4P4.setLayout(Color4P4Layout);
        Color4P4Layout.setHorizontalGroup(
            Color4P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color4P4Layout.setVerticalGroup(
            Color4P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Color3P4.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout Color3P4Layout = new javax.swing.GroupLayout(Color3P4);
        Color3P4.setLayout(Color3P4Layout);
        Color3P4Layout.setHorizontalGroup(
            Color3P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color3P4Layout.setVerticalGroup(
            Color3P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Color2P4Layout = new javax.swing.GroupLayout(Color2P4);
        Color2P4.setLayout(Color2P4Layout);
        Color2P4Layout.setHorizontalGroup(
            Color2P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color2P4Layout.setVerticalGroup(
            Color2P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Color1P4.setBackground(new java.awt.Color(255, 255, 51));

        javax.swing.GroupLayout Color1P4Layout = new javax.swing.GroupLayout(Color1P4);
        Color1P4.setLayout(Color1P4Layout);
        Color1P4Layout.setHorizontalGroup(
            Color1P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color1P4Layout.setVerticalGroup(
            Color1P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Vial4.setLayer(Color4P4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Vial4.setLayer(Color3P4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Vial4.setLayer(Color2P4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Vial4.setLayer(Color1P4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Vial4Layout = new javax.swing.GroupLayout(Vial4);
        Vial4.setLayout(Vial4Layout);
        Vial4Layout.setHorizontalGroup(
            Vial4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Vial4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(Vial4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Color1P4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Color2P4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Color3P4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Color4P4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        Vial4Layout.setVerticalGroup(
            Vial4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Vial4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(Color4P4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Color3P4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Color2P4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Color1P4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Vial5.setBackground(new java.awt.Color(102, 102, 102));
        Vial5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Vial5MouseClicked(evt);
            }
        });

        Color4P5.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout Color4P5Layout = new javax.swing.GroupLayout(Color4P5);
        Color4P5.setLayout(Color4P5Layout);
        Color4P5Layout.setHorizontalGroup(
            Color4P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color4P5Layout.setVerticalGroup(
            Color4P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Color3P5Layout = new javax.swing.GroupLayout(Color3P5);
        Color3P5.setLayout(Color3P5Layout);
        Color3P5Layout.setHorizontalGroup(
            Color3P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color3P5Layout.setVerticalGroup(
            Color3P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Color2P5Layout = new javax.swing.GroupLayout(Color2P5);
        Color2P5.setLayout(Color2P5Layout);
        Color2P5Layout.setHorizontalGroup(
            Color2P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color2P5Layout.setVerticalGroup(
            Color2P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Color1P5.setBackground(new java.awt.Color(255, 153, 51));

        javax.swing.GroupLayout Color1P5Layout = new javax.swing.GroupLayout(Color1P5);
        Color1P5.setLayout(Color1P5Layout);
        Color1P5Layout.setHorizontalGroup(
            Color1P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Color1P5Layout.setVerticalGroup(
            Color1P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Vial5.setLayer(Color4P5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Vial5.setLayer(Color3P5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Vial5.setLayer(Color2P5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Vial5.setLayer(Color1P5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Vial5Layout = new javax.swing.GroupLayout(Vial5);
        Vial5.setLayout(Vial5Layout);
        Vial5Layout.setHorizontalGroup(
            Vial5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Vial5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(Vial5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Color1P5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Color2P5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Color3P5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Color4P5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        Vial5Layout.setVerticalGroup(
            Vial5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Vial5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(Color4P5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Color3P5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Color2P5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Color1P5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Vial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Vial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Vial3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Vial4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(Vial5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 92, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Vial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(Vial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(13, 13, 13)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Vial4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Vial5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Vial3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>                        


    private void checkIfWon() {
    boolean hasWon = true;
    HashSet<String> usedColors = new HashSet<>(); // Para almacenar los colores ya utilizados

    // Recorre cada vial
    for (int i = 0; i < viales.length; i++) {
        Stack<String> vial = viales[i];

        // Si el vial está vacío, lo ignoramos y continuamos revisando los demás
        if (vial.isEmpty()) {
            System.out.println("Vial " + (i + 1) + " está vacio y se ignora.");
            continue;
        }

        // Si el vial no está lleno, significa que el juego aún no ha terminado
        if (!vial.isFull()) {
            System.out.println("Vial " + (i + 1) + " no está completamente lleno.");
            hasWon = false;
            break;
        }

        // Verifica que todos los colores del vial sean iguales
        String firstColor = vial.peek(); // Toma el color en la parte superior como referencia
        System.out.println("Primer color del vial " + (i + 1) + ": " + firstColor);

        for (int j = 0; j <= vial.tope; j++) { // Asumiendo que `tope` es el índice del tope de la pila
            String color = vial.getColorAt(j); // Obtener el color en una posición específica
            System.out.println("Comparando color en posicion " + j + ": " + color);
            if (!color.equals(firstColor)) {
                System.out.println("Color diferente encontrado en el vial " + (i + 1));
                hasWon = false; // Si hay un color diferente, no se ha ganado
                break;
            }
        }

        // Verifica que este color no se haya utilizado antes en otra pila
        if (usedColors.contains(firstColor)) {
            System.out.println("Color repetido encontrado: " + firstColor);
            hasWon = false; // Si el color ya fue utilizado en otra pila, no se ha ganado
            break;
        } else {
            usedColors.add(firstColor); // Agrega el color a la lista de colores utilizados
        }

        if (!hasWon) break; // Si alguna de las condiciones falla, salimos del bucle
    }

    // Si hasWon sigue siendo true, significa que se cumplen las condiciones para ganar
    if (hasWon) {
        int score = (int)(100*Math.random());
        Score s = new Score(dificulty-2, score);
        s.setVisible(true);
        dispose();
    } else {
        System.out.println("Aun no has ganado.");
    }
}
    private void Vial1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Vial1MouseClicked
        handleVialClick(1);  
        quitBorders();
        Vial1.setBorder(border);
        System.out.println("Vial1 clicked");
         
    }//GEN-LAST:event_Vial1MouseClicked

    private void Vial4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Vial4MouseClicked
        handleVialClick(4);  
        quitBorders();
        Vial4.setBorder(border);
        System.out.println("Vial4 clicked");
   
    }//GEN-LAST:event_Vial4MouseClicked

    private void Vial2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Vial2MouseClicked
        handleVialClick(2);  
        quitBorders();
        Vial2.setBorder(border);
        System.out.println("Vial2 clicked");
       
    }//GEN-LAST:event_Vial2MouseClicked

    private void Vial3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Vial3MouseClicked
        handleVialClick(3);  
        quitBorders();
        Vial3.setBorder(border);
        System.out.println("Vial3 clicked");
       
    }//GEN-LAST:event_Vial3MouseClicked

    private void Vial5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Vial5MouseClicked
        handleVialClick(5);  
        quitBorders();
        Vial5.setBorder(border);
        System.out.println("Vial5 clicked");
          
    }//GEN-LAST:event_Vial5MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Color1P1;
    private javax.swing.JPanel Color1P2;
    private javax.swing.JPanel Color1P3;
    private javax.swing.JPanel Color1P4;
    private javax.swing.JPanel Color1P5;
    private javax.swing.JPanel Color2P1;
    private javax.swing.JPanel Color2P2;
    private javax.swing.JPanel Color2P3;
    private javax.swing.JPanel Color2P4;
    private javax.swing.JPanel Color2P5;
    private javax.swing.JPanel Color3P1;
    private javax.swing.JPanel Color3P2;
    private javax.swing.JPanel Color3P3;
    private javax.swing.JPanel Color3P4;
    private javax.swing.JPanel Color3P5;
    private javax.swing.JPanel Color4P1;
    private javax.swing.JPanel Color4P2;
    private javax.swing.JPanel Color4P3;
    private javax.swing.JPanel Color4P4;
    private javax.swing.JPanel Color4P5;
    private javax.swing.JLayeredPane Vial1;
    private javax.swing.JLayeredPane Vial2;
    private javax.swing.JLayeredPane Vial3;
    private javax.swing.JLayeredPane Vial4;
    private javax.swing.JLayeredPane Vial5;
    // End of variables declaration//GEN-END:variables
}
