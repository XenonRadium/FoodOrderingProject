import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class MainPage extends JFrame {
    //Attributes
    public int orderID = 0;
    public String FoodOption = "";
    public ArrayList<String> Condiments = new ArrayList<String>();
    public ArrayList<Order> OrderList = new ArrayList<Order>();
    public String PaymentMethod;
    public double TotalPrice;
    public Boolean RequestReceipt;
    public Database FoodOrderdb = new Database();

    //Icon
    ImageIcon icon = new ImageIcon("UOW.png");
    JLabel label = new JLabel(icon);

    //Title
    ImageIcon title = new ImageIcon("MainPageTitleResized.png");
    JLabel titleLabel = new JLabel(title);

    //Start Order Button
    JButton StartOrder = new JButton(new ImageIcon("MainPageCreateResized.png"));

    //OrderPage WhatAreYouCravingToday Title
    ImageIcon OrderTitle = new ImageIcon("WhatAreYouCravingTodayBackgroundRemovedResized.png");
    JLabel label1 = new JLabel(OrderTitle);

    //PokeBowl Icon
    ImageIcon PokeBowl = new ImageIcon("PokeBowlIconRemovedResized.png");
    ImageIcon PokeBowlSelected = new ImageIcon("PokeBowlSelectedIconRemovedResized.png");
    JButton FoodIcon1 = new JButton(PokeBowl);

    //FoodChoice2 Icon
    ImageIcon FoodChoice2 = new ImageIcon("FoodChoice2ResizedRemoved.png");
    ImageIcon FoodChoice2Selected = new ImageIcon("FoodChoice2SelectedRemovedResized.png");
    JButton FoodIcon2 = new JButton(FoodChoice2);

    //FoodChoice3 Icon
    ImageIcon FoodChoice3 = new ImageIcon("FoodChoice3ResizedRemoved.png");
    ImageIcon FoodChoice3Selected = new ImageIcon("FoodChoice3SelectedRemovedResized.png");
    JButton FoodIcon3 = new JButton(FoodChoice3);

    //OrderPage CondimentsTitle
    ImageIcon CondimentsTitle = new ImageIcon("InterestedInAddingOnCondimentsRemovedResized.png");
    JLabel CondimentsLabel = new JLabel(CondimentsTitle);

    //Cheese Condiment
    ImageIcon CheeseCondiment = new ImageIcon ("CheeseCondimentRemovedResized.png");
    ImageIcon CheeseCondimentSelected = new ImageIcon("CheeseCondimentSelectedRemovedResized.png");
    JButton CheeseIcon = new JButton(CheeseCondiment);

    //Sweet Onion Condiment
    ImageIcon SweetOnionCondiment = new ImageIcon("SweetOnionCondimentRemovedResized.png");
    ImageIcon SweetOnionCondimentSelected = new ImageIcon("SweetOnionCondimentSelectedRemovedResized.png");
    JButton SweetOnionIcon = new JButton(SweetOnionCondiment);

    //Crushed Mix Nuts condiment
    ImageIcon CrushedMixNutsCondiment = new ImageIcon("CrushedMixNutsRemovedResized.png");
    ImageIcon CrushedMixNutsCondimentSelected = new ImageIcon("CrushedMixNutsSelectedRemovedResized.png");
    JButton CrushedMixNutsIcon = new JButton(CrushedMixNutsCondiment);

    //BBQ Condiment
    ImageIcon BBQCondiment = new ImageIcon("BBQCondimentResizedRemoved.png");
    ImageIcon BBQCondimentSelected = new ImageIcon("BBQCondimentSelectedRemovedResized.png");
    JButton BBQIcon = new JButton(BBQCondiment);

    //Honey Mustard
    ImageIcon HoneyMustardCondiment = new ImageIcon("HoneyMustardCondimentRemovedResized.png");
    ImageIcon HoneyMustardCondimentSelected = new ImageIcon("HoneyMustardCondimentSelectedRemovedResized.png");
    JButton HoneyMustardIcon = new JButton(HoneyMustardCondiment);

    //Mayonnaise
    ImageIcon MayonnaiseCondiment = new ImageIcon("MayonnaiseCondimentRemovedResized.png");
    ImageIcon MayonnaiseCondimentSelected = new ImageIcon("MayonnaiseCondimentSelectedRemovedResized.png");
    JButton MayonnaiseIcon = new JButton(MayonnaiseCondiment);

    //NextPage
    ImageIcon NextPage = new ImageIcon("NextPageButtonRemovedResized.png");
    JButton MainToOrderNext = new JButton(NextPage);

    //HelpButton
    ImageIcon Help = new ImageIcon("HelpButtonRemovedResized.png");
    JButton OrderHelp = new JButton(Help);

    //Summary Title
    ImageIcon SummaryTitle = new ImageIcon("SummaryPageTitleRemovedResized.png");
    JLabel SummaryLabel = new JLabel(SummaryTitle);

    //Summary Box Background
    ImageIcon SummaryBackground = new ImageIcon("SummaryBoxRemovedResized.png");
    JTextArea FalseOrderBox = new JTextArea(7,31)
    {
        //Order Summary
        Image img = SummaryBackground.getImage();
        {
            //Toggle to allow image
            setOpaque(false);
            setEditable(false);
        }
        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, this);
            super.paint(g);
        }
    };

    //Summary Box
    JTextArea OrderBox = new JTextArea(6,29);

    //SummaryPrice
    ImageIcon PriceBackground = new ImageIcon("SummaryPriceResized.png");
    JTextArea PriceBox = new JTextArea(3,10)
    {
      Image PriceImage= PriceBackground.getImage();
        {
            setOpaque(false);
            setEditable(false);
        }
        public void paint(Graphics g){
            g.drawImage(PriceImage,0,0,this);
            super.paint(g);
        }
    };

    ImageIcon ConfirmTitle = new ImageIcon("ConfirmTitleRemovedResized.png");
    JLabel ConfirmLabel = new JLabel(ConfirmTitle);

    //Summary Yes
    ImageIcon YesButton = new ImageIcon("SummaryYesRemovedResized.png");
    ImageIcon YesButtonSelected = new ImageIcon("SummaryYesSelectedRemovedResized.png");
    JButton YesButtonIcon = new JButton(YesButton);

    //Summary No
    ImageIcon NoButton = new ImageIcon("SummaryNoRemovedResized.png");
    ImageIcon NoButtonSelected = new ImageIcon("SummaryNoSelectedRemovedResized.png");
    JButton NoButtonIcon = new JButton(NoButton);

    //Order to Summary
    JButton OrdertoSummary = new JButton(NextPage);

    //SummaryHelp
    JButton SummaryHelp = new JButton(Help);

    //Payment Title
    ImageIcon PaymentTitle = new ImageIcon("PaymentTitleRemovedResized.png");
    JLabel PaymentLabel = new JLabel(PaymentTitle);

    //Debit
    ImageIcon DebitButton = new ImageIcon("DebitButtonRemovedResized.png");
    ImageIcon DebitButtonSelected = new ImageIcon("DebitButtonSelectedRemovedResized.png");
    JButton DebitIcon = new JButton(DebitButton);

    //Cash
    ImageIcon CashButton = new ImageIcon("CashButtonRemovedResized.png");
    ImageIcon CashButtonSelected  = new ImageIcon("CashButtonSelectedRemovedResized.png");
    JButton CashIcon = new JButton(CashButton);

    //Receipt Title
    ImageIcon ReceiptTitle = new ImageIcon("ReceiptTitleRemovedResized.png");
    JLabel ReceiptLabel = new JLabel(ReceiptTitle);

    //YesPlease
    ImageIcon YesPlease = new ImageIcon("YesPleaseRemovedResized.png");
    ImageIcon YesPleaseSelected = new ImageIcon("YesPleaseSelectedRemovedResized.png");
    JButton YesPleaseIcon = new JButton(YesPlease);

    //NoThankYou
    ImageIcon NoThankYou = new ImageIcon("NoThankYouRemovedResized.png");
    ImageIcon NoThankYouSelected = new ImageIcon("NoThankYouSelectedRemovedResized.png");
    JButton NoThankYouIcon = new JButton(NoThankYou);

    //PaymentHelp
    JButton PaymentHelpIcon = new JButton(Help);

    //PaymentToLast
    JButton PaymentToLast = new JButton(NextPage);

    //LastPageSummary
    ImageIcon LastSummaryBackground = new ImageIcon("LastPageBoxResized.png");
    JTextArea LastSummary = new JTextArea(18,50)
    {
        Image LastSummaryImage= LastSummaryBackground.getImage();
        {
            setOpaque(false);
            setEditable(false);
        }
        public void paint(Graphics g){
            g.drawImage(LastSummaryImage,0,0,this);
            super.paint(g);
        }
    };

    //BackButton
    ImageIcon BackButton = new ImageIcon("BackButtonRemovedResized.png");
    JButton OrdertoMain = new JButton(BackButton);
    JButton SummarytoOrder = new JButton(BackButton);
    JButton PaymenttoSummary = new JButton(BackButton);

    //ReturnToHomepage
    ImageIcon ReturnToHomePageButton = new ImageIcon("ReturnToHomepageRemovedResized.png");
    JButton ReturnToHomePage = new JButton(ReturnToHomePageButton);




/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public MainPage() {
        FoodOrderdb.insertDatabase(100,"","",0.0);

        //Setting Up Pages
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        JPanel orderPage = new JPanel();
        orderPage.setLayout(null);

        JPanel SummaryPage = new JPanel();
        SummaryPage.setLayout(null);

        JPanel PaymentPage = new JPanel();
        PaymentPage.setLayout(null);

        JPanel LastPage = new JPanel();
        LastPage.setLayout(null);

        //JFrame for Error Messages
        JFrame OrderError = new JFrame();

        //JFrame for SummaryPage Error
        JFrame SummaryError = new JFrame();

        //JFrame for PaymentPage Error
        JFrame PaymentMethodError = new JFrame();

        JFrame PaymentReceiptError = new JFrame();

        JFrame PaymentMethodandReceiptError = new JFrame();

        JPanel CardManager = new JPanel();
        CardLayout card = new CardLayout();
        CardManager.setLayout(card);
        CardManager.add(main, "main");
        CardManager.add(orderPage, "orderPage");
        CardManager.add(SummaryPage, "summaryPage");
        CardManager.add(PaymentPage,"paymentPage");
        CardManager.add(LastPage,"lastPage");

        //Setting up JFrame
        JFrame canvas = new JFrame();
        canvas.add(CardManager);
        canvas.setSize(700, 550);
//***************Main Page*********************
        //Top Frame
        JPanel Bottom = new JPanel(new FlowLayout());

        //Add Main Components
        main.add(label, BorderLayout.CENTER);

        main.add(titleLabel, BorderLayout.PAGE_START);

        StartOrder.setBorder(BorderFactory.createEmptyBorder());
        StartOrder.setContentAreaFilled(false);
        StartOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setSize(700, 600);
                card.next(CardManager);
            }
        });
        main.setBackground(new java.awt.Color(225, 245, 245));
        Bottom.setBackground(new java.awt.Color(225, 245, 245));
        Bottom.add(StartOrder);
        main.add(Bottom, BorderLayout.PAGE_END);
//*************************Main Page***************************






//*************************Order Page****************************
        orderPage.setBackground(new java.awt.Color(225, 245, 245));
        orderPage.add(label1);orderPage.add(FoodIcon1);orderPage.add(FoodIcon2);orderPage.add(FoodIcon3);
        orderPage.add(CondimentsLabel);orderPage.add(CheeseIcon);orderPage.add(SweetOnionIcon);
        orderPage.add(CrushedMixNutsIcon);orderPage.add(BBQIcon);orderPage.add(HoneyMustardIcon);
        orderPage.add(MayonnaiseIcon);orderPage.add(MainToOrderNext); orderPage.add(OrderHelp);
        orderPage.add(OrdertoMain);

        Insets insets = orderPage.getInsets();

        Dimension size = label1.getPreferredSize();
        label1.setBounds(40 + insets.left, 50 + insets.top, size.width, size.height);

        Dimension size1 = FoodIcon1.getPreferredSize();
        FoodIcon1.setBounds(100 + insets.left, 120 + insets.top, size1.width, size1.height);
        FoodIcon1.setBorder(BorderFactory.createEmptyBorder());
        FoodIcon1.setContentAreaFilled(false);
        FoodIcon1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (FoodIcon1.getIcon() == PokeBowl)
                {
                    FoodIcon1.setIcon(PokeBowlSelected);
                    FoodIcon2.setIcon(FoodChoice2);
                    FoodIcon3.setIcon(FoodChoice3);
                    SetFoodOption(1);
                }
                else if(FoodIcon1.getIcon() == PokeBowlSelected)
                {
                    FoodIcon1.setIcon(PokeBowl);
                    SetFoodOption(4);
                }
            }
        });

        Dimension size2 = FoodIcon2.getPreferredSize();
        FoodIcon2.setBounds(270 + insets.left, 120 + insets.top, size2.width, size2.height);
        FoodIcon2.setBorder(BorderFactory.createEmptyBorder());
        FoodIcon2.setContentAreaFilled(false);
        FoodIcon2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (FoodIcon2.getIcon() == FoodChoice2)
                {
                    FoodIcon2.setIcon(FoodChoice2Selected);
                    FoodIcon1.setIcon(PokeBowl);
                    FoodIcon3.setIcon(FoodChoice3);
                    SetFoodOption(2);
                }
                else if(FoodIcon2.getIcon() == FoodChoice2Selected)
                {
                    FoodIcon2.setIcon(FoodChoice2);
                    SetFoodOption(4);
                }
            }
        });


        Dimension size3 = FoodIcon3.getPreferredSize();
        FoodIcon3.setBounds(440 + insets.left, 120 + insets.top, size3.width, size3.height);
        FoodIcon3.setBorder(BorderFactory.createEmptyBorder());
        FoodIcon3.setContentAreaFilled(false);
        FoodIcon3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (FoodIcon3.getIcon() == FoodChoice3)
                {
                    FoodIcon3.setIcon(FoodChoice3Selected);
                    FoodIcon2.setIcon(FoodChoice2);
                    FoodIcon1.setIcon(PokeBowl);
                    SetFoodOption(3);
                }
                else if(FoodIcon3.getIcon() == FoodChoice3Selected)
                {
                    FoodIcon3.setIcon(FoodChoice3);
                    SetFoodOption(4);
                }
            }
        });

        Dimension size4 = CondimentsLabel.getPreferredSize();
        CondimentsLabel.setBounds(60 + insets.left, 260 + insets.top, size4.width, size4.height);

        Dimension size5 = CheeseIcon.getPreferredSize();
        CheeseIcon.setBounds(100 + insets.left, 300 + insets.top, size5.width, size5.height);
        CheeseIcon.setBorder(BorderFactory.createEmptyBorder());
        CheeseIcon.setContentAreaFilled(false);
        CheeseIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CheeseIcon.getIcon() == CheeseCondiment){
                    SetCheeseCondiments();
                    CheeseIcon.setIcon(CheeseCondimentSelected);
                }
                else if(CheeseIcon.getIcon() == CheeseCondimentSelected){
                    SetCheeseCondiments();
                    CheeseIcon.setIcon(CheeseCondiment);
                }
            }
        });

        Dimension size6 = SweetOnionIcon.getPreferredSize();
        SweetOnionIcon.setBounds(280 + insets.left, 300 + insets.top, size6.width, size6.height);
        SweetOnionIcon.setBorder(BorderFactory.createEmptyBorder());
        SweetOnionIcon.setContentAreaFilled(false);
        SweetOnionIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (SweetOnionIcon.getIcon() == SweetOnionCondiment){
                    SetSweetOnionCondiments();
                    SweetOnionIcon.setIcon(SweetOnionCondimentSelected);
                }
                else if (SweetOnionIcon.getIcon() == SweetOnionCondimentSelected){
                    SetSweetOnionCondiments();
                    SweetOnionIcon.setIcon(SweetOnionCondiment);
                }
            }
        });

        Dimension size7 = CrushedMixNutsIcon.getPreferredSize();
        CrushedMixNutsIcon.setBounds(460 + insets.left, 300 + insets.top, size7.width, size7.height);
        CrushedMixNutsIcon.setBorder(BorderFactory.createEmptyBorder());
        CrushedMixNutsIcon.setContentAreaFilled(false);
        CrushedMixNutsIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CrushedMixNutsIcon.getIcon() == CrushedMixNutsCondiment){
                    SetCrushedMixNutsCondiments();
                    CrushedMixNutsIcon.setIcon(CrushedMixNutsCondimentSelected);
                }
                else if (CrushedMixNutsIcon.getIcon() == CrushedMixNutsCondimentSelected){
                    SetCrushedMixNutsCondiments();
                    CrushedMixNutsIcon.setIcon(CrushedMixNutsCondiment);
                }
            }
        });

        Dimension size8 = BBQIcon.getPreferredSize();
        BBQIcon.setBounds(100 + insets.left, 400 + insets.top, size8.width, size8.height);
        BBQIcon.setBorder(BorderFactory.createEmptyBorder());
        BBQIcon.setContentAreaFilled(false);
        BBQIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (BBQIcon.getIcon() == BBQCondiment){
                    SetBBQCondiments();
                    BBQIcon.setIcon(BBQCondimentSelected);
                }
                else if (BBQIcon.getIcon() == BBQCondimentSelected){
                    SetBBQCondiments();
                    BBQIcon.setIcon(BBQCondiment);
                }
            }
        });


        Dimension size9 = HoneyMustardIcon.getPreferredSize();
        HoneyMustardIcon.setBounds(280 + insets.left, 400 + insets.top, size9.width, size9.height);
        HoneyMustardIcon.setBorder(BorderFactory.createEmptyBorder());
        HoneyMustardIcon.setContentAreaFilled(false);
        HoneyMustardIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (HoneyMustardIcon.getIcon() == HoneyMustardCondiment){
                    SetHoneyMustardCondiments();
                    HoneyMustardIcon.setIcon(HoneyMustardCondimentSelected);
                }
                else if (HoneyMustardIcon.getIcon() == HoneyMustardCondimentSelected){
                    SetHoneyMustardCondiments();
                    HoneyMustardIcon.setIcon(HoneyMustardCondiment);
                }
            }
        });

        Dimension size10 = MayonnaiseIcon.getPreferredSize();
        MayonnaiseIcon.setBounds(460 + insets.left, 400 + insets.top, size10.width, size10.height);
        MayonnaiseIcon.setBorder(BorderFactory.createEmptyBorder());
        MayonnaiseIcon.setContentAreaFilled(false);
        MayonnaiseIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(MayonnaiseIcon.getIcon() == MayonnaiseCondiment){
                    SetMayonnaiseCondiments();
                    MayonnaiseIcon.setIcon(MayonnaiseCondimentSelected);
                }
                else if(MayonnaiseIcon.getIcon() == MayonnaiseCondimentSelected){
                    SetMayonnaiseCondiments();
                    MayonnaiseIcon.setIcon(MayonnaiseCondiment);
                }
            }
        });

        Dimension size11 = MainToOrderNext.getPreferredSize();
        MainToOrderNext.setBounds(500 + insets.left, 490 + insets.top, size11.width, size11.height);
        MainToOrderNext.setBorder(BorderFactory.createEmptyBorder());
        MainToOrderNext.setContentAreaFilled(false);
        MainToOrderNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (FoodIcon1.getIcon() == PokeBowl && FoodIcon2.getIcon() == FoodChoice2 && FoodIcon3.getIcon() == FoodChoice3){
                    JOptionPane.showMessageDialog(OrderError,"Please Select a Food Choice");}
                else{
                    card.next(CardManager);
                    canvas.setSize(700, 600);
                    setTotalPrice();
                    display();}
            }
        });

        Dimension size12 = OrderHelp.getPreferredSize();
        OrderHelp.setBounds(10 + insets.left, 10 + insets.top, size12.width, size12.height);
        OrderHelp.setBorder(BorderFactory.createEmptyBorder());
        OrderHelp.setContentAreaFilled(false);

        Dimension OrdertoMainSize = OrdertoMain.getPreferredSize();
        OrdertoMain.setBounds(insets.left, 490 + insets.top, OrdertoMainSize.width, OrdertoMainSize.height);
        OrdertoMain.setBorder(BorderFactory.createEmptyBorder());
        OrdertoMain.setContentAreaFilled(false);
        OrdertoMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.previous(CardManager);
                canvas.setSize(700,550);
                reset();
            }
        });
//************************Order Page*******************************






//************************Summary Page******************************
        SummaryPage.setBackground(new java.awt.Color(225, 245, 245));
        SummaryPage.add(OrderBox);SummaryPage.add(SummaryLabel);SummaryPage.add(ConfirmLabel);SummaryPage.add(YesButtonIcon);
        SummaryPage.add(NoButtonIcon);SummaryPage.add(OrdertoSummary);SummaryPage.add(SummaryHelp);
        SummaryPage.add(SummarytoOrder);

        Insets SummaryInsets = SummaryPage.getInsets();

        //OrderSummary
        OrderBox.setOpaque(false);
        OrderBox.setLineWrap(true);
        JScrollPane orderBoxs = new JScrollPane(OrderBox);
        orderBoxs.setOpaque(false);
        orderBoxs.getViewport().setOpaque(false);
        SummaryPage.add(orderBoxs);
        Dimension sizeOrderBox = OrderBox.getPreferredSize();
        orderBoxs.setBounds(230 + SummaryInsets.left, 110 + SummaryInsets.top, sizeOrderBox.width, sizeOrderBox.height);
        orderBoxs.setBorder(BorderFactory.createEmptyBorder());
        Font font = new Font("Segoe Script", Font.BOLD,12);
        OrderBox.setFont(font);

        //OrderSummaryBackground
        FalseOrderBox.setLineWrap(true);
        JScrollPane orderBox = new JScrollPane(FalseOrderBox);
        SummaryPage.add((orderBox));
        Dimension size13 = orderBox.getPreferredSize();
        orderBox.setBounds(220 + SummaryInsets.left, 100 + SummaryInsets.top, size13.width, size13.height);
        orderBox.setBorder(BorderFactory.createEmptyBorder());


        //SummaryLabel
        Dimension size14 = SummaryLabel.getPreferredSize();
        SummaryLabel.setBounds(230 + SummaryInsets.left, 50 + SummaryInsets.top, size14.width, size14.height);

        //Title
        Dimension size15 = ConfirmLabel.getPreferredSize();
        ConfirmLabel.setBounds(200 + SummaryInsets.left, 320 + SummaryInsets.top, size15.width, size15.height);

        //Help
        Dimension size19 = SummaryHelp.getPreferredSize();
        SummaryHelp.setBounds(10 + SummaryInsets.left, 10 + SummaryInsets.top, size19.width, size19.height);
        SummaryHelp.setBorder(BorderFactory.createEmptyBorder());
        SummaryHelp.setContentAreaFilled(false);
        SummaryHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //OrderSummary
        PriceBox.setLineWrap(true);
        JScrollPane priceBox = new JScrollPane(PriceBox);
        SummaryPage.add((priceBox));
        Dimension size20 = priceBox.getPreferredSize();
        priceBox.setBounds(435 + SummaryInsets.left, 210 + SummaryInsets.top, size20.width, size20.height);
        priceBox.setBorder(BorderFactory.createEmptyBorder());
        PriceBox.setFont(font);

        //SummaryYes
        Dimension size16 = YesButtonIcon.getPreferredSize();
        YesButtonIcon.setBounds(200 + SummaryInsets.left, 370 + SummaryInsets.top, size16.width, size16.height);
        YesButtonIcon.setBorder(BorderFactory.createEmptyBorder());
        YesButtonIcon.setContentAreaFilled(false);
        YesButtonIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                YesButtonIcon.setIcon(YesButtonSelected);
                NoButtonIcon.setIcon(NoButton);
            }
        });

        //SummaryNo
        Dimension size17 = NoButtonIcon.getPreferredSize();
        NoButtonIcon.setBounds(350 + SummaryInsets.left, 370 + SummaryInsets.top, size17.width, size17.height);
        NoButtonIcon.setBorder(BorderFactory.createEmptyBorder());
        NoButtonIcon.setContentAreaFilled(false);
        NoButtonIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NoButtonIcon.setIcon(NoButtonSelected);
                YesButtonIcon.setIcon(YesButton);
            }
        });

        //SummaryToOrderBack
        Dimension SummarytoOrderSize = SummarytoOrder.getPreferredSize();
        SummarytoOrder.setBounds(SummaryInsets.left, 490 + SummaryInsets.top, SummarytoOrderSize.width, SummarytoOrderSize.height);
        SummarytoOrder.setBorder(BorderFactory.createEmptyBorder());
        SummarytoOrder.setContentAreaFilled(false);
        SummarytoOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.previous(CardManager);
                canvas.setSize(700,600);
            }
        });

        //OrderToSummary
        Dimension size18 = OrdertoSummary.getPreferredSize();
        OrdertoSummary.setBounds(500 + SummaryInsets.left, 490 + SummaryInsets.top, size18.width, size18.height);
        OrdertoSummary.setBorder(BorderFactory.createEmptyBorder());
        OrdertoSummary.setContentAreaFilled(false);
        OrdertoSummary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (YesButtonIcon.getIcon() == YesButton && NoButtonIcon.getIcon() == NoButton){
                    JOptionPane.showMessageDialog(SummaryError,"Please decide if you want to order another order.");
                }else {
                    if (YesButtonIcon.getIcon() == YesButtonSelected) {
                        card.next(CardManager);
                        canvas.setSize(700, 600);
                        StoreOrder();
                    } else if (NoButtonIcon.getIcon() == NoButtonSelected) {
                        card.show(CardManager, "orderPage");
                        canvas.setSize(700, 600);
                        StoreOrder();
                        reset();
                    }
                }
            }
        });
//*************************************Summary Page*******************************************************





//************************************Payment Page********************************************************
        PaymentPage.setBackground(new java.awt.Color(225, 245, 245));
        PaymentPage.add(PaymentLabel);PaymentPage.add(DebitIcon);PaymentPage.add(CashIcon);
        PaymentPage.add(ReceiptLabel);PaymentPage.add(YesPleaseIcon);PaymentPage.add(NoThankYouIcon);
        PaymentPage.add(PaymentHelpIcon);PaymentPage.add(PaymentToLast);PaymentPage.add(PaymenttoSummary);

        Insets PaymentInsets = PaymentPage.getInsets();

        //Payment Title
        Dimension size21 = PaymentLabel.getPreferredSize();
        PaymentLabel.setBounds(290 + PaymentInsets.left, 80 + PaymentInsets.top, size21.width, size21.height);

        //Debit Button
        Dimension size22 = DebitIcon.getPreferredSize();
        DebitIcon.setBounds(160 + PaymentInsets.left, 150 + PaymentInsets.top, size22.width, size22.height);
        DebitIcon.setBorder(BorderFactory.createEmptyBorder());
        DebitIcon.setContentAreaFilled(false);
        DebitIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (DebitIcon.getIcon() == DebitButton){
                    DebitIcon.setIcon(DebitButtonSelected);
                    CashIcon.setIcon(CashButton);
                }
            }
        });

        //Cash Button
        Dimension size23 = CashIcon.getPreferredSize();
        CashIcon.setBounds(400 + PaymentInsets.left, 150 + PaymentInsets.top, size23.width, size23.height);
        CashIcon.setBorder(BorderFactory.createEmptyBorder());
        CashIcon.setContentAreaFilled(false);
        CashIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CashIcon.getIcon() == CashButton){
                    CashIcon.setIcon(CashButtonSelected);
                    DebitIcon.setIcon(DebitButton);
                }
            }
        });

        //Receipt Title
        Dimension size24 = ReceiptLabel.getPreferredSize();
        ReceiptLabel.setBounds(250 + PaymentInsets.left, 330 + PaymentInsets.top, size24.width, size24.height);

        //YesPlease
        Dimension size25 = YesPleaseIcon.getPreferredSize();
        YesPleaseIcon.setBounds(160 + PaymentInsets.left, 400 + PaymentInsets.top, size25.width, size25.height);
        YesPleaseIcon.setBorder(BorderFactory.createEmptyBorder());
        YesPleaseIcon.setContentAreaFilled(false);
        YesPleaseIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    YesPleaseIcon.setIcon(YesPleaseSelected);
                    NoThankYouIcon.setIcon(NoThankYou);
            }
        });

        //NoThankYou
        Dimension size26 = NoThankYouIcon.getPreferredSize();
        NoThankYouIcon.setBounds(400 + PaymentInsets.left, 400 + PaymentInsets.top, size26.width, size26.height);
        NoThankYouIcon.setBorder(BorderFactory.createEmptyBorder());
        NoThankYouIcon.setContentAreaFilled(false);
        NoThankYouIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    NoThankYouIcon.setIcon(NoThankYouSelected);
                    YesPleaseIcon.setIcon(YesPlease);
            }
        });

        //Payment Help
        Dimension size27 = PaymentHelpIcon.getPreferredSize();
        PaymentHelpIcon.setBounds(10 + PaymentInsets.left, 10 + PaymentInsets.top, size27.width, size27.height);
        PaymentHelpIcon.setBorder(BorderFactory.createEmptyBorder());
        PaymentHelpIcon.setContentAreaFilled(false);

        //Payment To Last
        Dimension size28 = PaymentToLast.getPreferredSize();
        PaymentToLast.setBounds(500 + PaymentInsets.left, 490 + PaymentInsets.top, size28.width, size28.height);
        PaymentToLast.setBorder(BorderFactory.createEmptyBorder());
        PaymentToLast.setContentAreaFilled(false);
        PaymentToLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (DebitIcon.getIcon() == DebitButton && CashIcon.getIcon() == CashButton &&
                        YesPleaseIcon.getIcon() == YesPlease && NoThankYouIcon.getIcon() == NoThankYou) {
                    JOptionPane.showMessageDialog(PaymentMethodandReceiptError, "Please select a payment method and " +
                            "confirm if you want a receipt or not");}
                else if (DebitIcon.getIcon() == DebitButton && CashIcon.getIcon() == CashButton) {
                    JOptionPane.showMessageDialog(PaymentMethodError, "Please Select a payment method");
                } else if (YesPleaseIcon.getIcon() == YesPlease && NoThankYouIcon.getIcon() == NoThankYou) {
                    JOptionPane.showMessageDialog(PaymentReceiptError, "Do you want a receipt?");
                } else {
                    if (DebitIcon.getIcon() == DebitButtonSelected &&
                            YesPleaseIcon.getIcon() == YesPleaseSelected) {
                        setPaymentMethod(0);
                        setRequestReceipt(1);
                        printReceipt();
                        InsertIntoDatabase();
                    } else if (DebitIcon.getIcon() == DebitButtonSelected &&
                            NoThankYouIcon.getIcon() == NoThankYouSelected) {
                        setPaymentMethod(0);
                        setRequestReceipt(0);
                        InsertIntoDatabase();
                    } else if (CashIcon.getIcon() == CashButtonSelected &&
                            YesPleaseIcon.getIcon() == YesPleaseSelected) {
                        setPaymentMethod(1);
                        setRequestReceipt(1);
                        printReceipt();
                        InsertIntoDatabase();
                    } else if (CashIcon.getIcon() == CashButtonSelected &&
                            NoThankYouIcon.getIcon() == NoThankYouSelected) {
                        setPaymentMethod(1);
                        setRequestReceipt(0);
                        InsertIntoDatabase();
                    }
                    card.next(CardManager);
                    FullReset();
                }
            }
        });

        //PaymentToSummaryBack
        Dimension PaymentToSummarySize = PaymenttoSummary.getPreferredSize();
        PaymenttoSummary.setBounds(PaymentInsets.left, 490 + PaymentInsets.top, PaymentToSummarySize.width, PaymentToSummarySize.height);
        PaymenttoSummary.setBorder(BorderFactory.createEmptyBorder());
        PaymenttoSummary.setContentAreaFilled(false);
        PaymenttoSummary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.previous(CardManager);
                canvas.setSize(700,600);
            }
        });
//************************************Payment Page********************************************************





//************************************Last Page***********************************************************
        LastPage.setBackground(new java.awt.Color(225, 245, 245));
        LastPage.add(ReturnToHomePage);

        Insets LastPageInsets = LastPage.getInsets();

        //LastSummary
        LastSummary.setLineWrap(true);
        JScrollPane LastSummaryBox = new JScrollPane(LastSummary);
        LastPage.add((LastSummaryBox));
        Dimension size29 = LastSummary.getPreferredSize();
        LastSummaryBox.setBounds(100 + LastPageInsets.left, 100 + LastPageInsets.top, size29.width, size29.height);
        LastSummaryBox.setBorder(BorderFactory.createEmptyBorder());

        //ReturnToHomepage
        Dimension size30 = ReturnToHomePage.getPreferredSize();
        ReturnToHomePage.setBounds(200 + LastPageInsets.left, 400 + LastPageInsets.top, size30.width, size30.height);
        ReturnToHomePage.setBorder(BorderFactory.createEmptyBorder());
        ReturnToHomePage.setContentAreaFilled(false);
        ReturnToHomePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(CardManager, "main");
            }
        });
//************************************Last Page***********************************************************


        //Set Canvas Attributes
        canvas.setResizable(false);
        canvas.setLocationRelativeTo(null);
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setVisible(true);
        canvas.getContentPane().setBackground(new java.awt.Color(225, 245, 245));
    }
//**********************************************************************************************************




    private void SetFoodOption(int Option){
        if (Option == 1) {
            FoodOption = "PokeBowl";
//            System.out.println(FoodOption);
        }
        else if (Option == 2) {
            FoodOption = "Food Option 2";
//            System.out.println(FoodOption);
        }
        else if (Option == 3) {
            FoodOption = "Food Option 3";
//            System.out.println(FoodOption);
        }
        else if (Option == 4) {
            FoodOption = "";
//            System.out.println(FoodOption);
        }
    }

    private void SetCheeseCondiments(){
        if (!Condiments.contains("Cheese")) {
            Condiments.add("Cheese");
//            System.out.println(Condiments.toString());
        }
        else if (Condiments.contains("Cheese")) {
            Condiments.remove("Cheese");
//            System.out.println(Condiments.toString());
        }
    }

    private void SetSweetOnionCondiments() {
        if (!Condiments.contains("Sweet Onion")) {
            Condiments.add("Sweet Onion");
//            System.out.println(Condiments.toString());
        } else if (Condiments.contains("Sweet Onion")) {
            Condiments.remove("Sweet Onion");
//            System.out.println(Condiments.toString());
        }
    }

    private void SetCrushedMixNutsCondiments(){
        if (!Condiments.contains("Crushed Mix Nuts")) {
            Condiments.add("Crushed Mix Nuts");
//            System.out.println(Condiments.toString());
        }
        else if (Condiments.contains("Crushed Mix Nuts")) {
            Condiments.remove("Crushed Mix Nuts");
//            System.out.println(Condiments.toString());
        }
    }

    private void SetBBQCondiments(){
        if (!Condiments.contains("BBQ")) {
            Condiments.add("BBQ");
//            System.out.println(Condiments.toString());
        }
        else if (Condiments.contains("BBQ")) {
            Condiments.remove("BBQ");
//            System.out.println(Condiments.toString());
        }
    }

    private void SetHoneyMustardCondiments(){
        if (!Condiments.contains("Honey Mustard")) {
            Condiments.add("Honey Mustard");
//            System.out.println(Condiments.toString());
        }
        else if (Condiments.contains("Honey Mustard")) {
            Condiments.remove("Honey Mustard");
//            System.out.println(Condiments.toString());
        }
    }

    private void SetMayonnaiseCondiments(){
        if (!Condiments.contains("Mayonnaise")){
            Condiments.add("Mayonnaise");
//            System.out.println(Condiments.toString());
            }
        else if (Condiments.contains("Mayonnaise")) {
            Condiments.remove("Mayonnaise");
//            System.out.println(Condiments.toString());
        }
    }

    public static String listToString(ArrayList<?> list) {
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() -1)
                result += list.get(i) + ", ";
            else
                result += list.get(i);
        }

//        System.out.println(result);
        return result;
    }

    public static void orderToString(ArrayList<Order> list){
        for (int i = 0; i < list.size(); i++){
            if (i != list.size() -1){
                System.out.print(list.get(i).getFoodOption() + "\n" + listToString(list.get(i).getCondiments())
                        + "\n" + list.get(i).getPrice()+ "\n");
            }
            else System.out.println(list.get(i).getFoodOption() + "\n" + listToString(list.get(i).getCondiments())
                    + "\n" + list.get(i).getPrice()+ "\n");
        }
    }

    public void display(){
        //orderToString(OrderList);
        String result = "";
        Double price = 0.0;
        if (OrderList.size() > 0){
            for (int i = 0; i < OrderList.size(); i++){
                result += "Food Option: " + OrderList.get(i).getFoodOption() + "\nCondiments: "
                        + listToString(OrderList.get(i).getCondiments()) + "\n\n";
                price += OrderList.get(i).getPrice();
            }
        }

        result += "FoodOption: " + FoodOption + "\nCondiments: " + listToString(Condiments) + "\n\n";
        price += TotalPrice;

        PriceBox.setText("\n" + "RM" + Double.toString(price));
        OrderBox.setText(result);
    }

    public void setTotalPrice(){
        if (FoodOption.equals("")) {
            TotalPrice = Condiments.size();
        }else TotalPrice = 12.90 + Condiments.size();
    }

    public void setPaymentMethod(int paymentMode){
        if (paymentMode == 0){
            PaymentMethod = "Debit Card";
        }else if (paymentMode == 1){
            PaymentMethod = "Cash";
        }
    }

    public void setRequestReceipt(int receiptMode){
        if (receiptMode == 0){
            RequestReceipt = false;
        }else if (receiptMode == 1){
            RequestReceipt = true;
        }
    }

    public void printReceipt(){
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        String receiptToString = "UOWKDU Receipt\n" + df.format(dateobj) + "\n\n";
        Double price = 0.0;
        if (RequestReceipt){
            if (OrderList.size() > 0){
                for (int i = 0; i < OrderList.size(); i++){
                    receiptToString += "Food Option: " + OrderList.get(i).getFoodOption() + "\nCondiments: "
                            + listToString(OrderList.get(i).getCondiments()) + "\n";
                    price += OrderList.get(i).getPrice();
                }
            }
            System.out.println(receiptToString);
            System.out.println("RM" + price);
        }
    }

    public void StoreOrder(){
        Order newOrder = new Order(orderID, FoodOption, Condiments, TotalPrice);
        OrderList.add(newOrder);
        orderID++;
    }

    public String getFoodOption (){
        return FoodOption;
    }

    public void reset(){
        Condiments.clear();
        SetFoodOption(4);
        FoodIcon1.setIcon(PokeBowl);FoodIcon2.setIcon(FoodChoice2);
        FoodIcon3.setIcon(FoodChoice3);

        CheeseIcon.setIcon(CheeseCondiment);SweetOnionIcon.setIcon(SweetOnionCondiment);
        CrushedMixNutsIcon.setIcon(CrushedMixNutsCondiment);BBQIcon.setIcon(BBQCondiment);
        HoneyMustardIcon.setIcon(HoneyMustardCondiment);MayonnaiseIcon.setIcon(MayonnaiseCondiment);

        YesButtonIcon.setIcon(YesButton);NoButtonIcon.setIcon(NoButton);
        YesPleaseIcon.setIcon(YesPlease);NoThankYouIcon.setIcon(NoThankYou);
        DebitIcon.setIcon(DebitButton);CashIcon.setIcon(CashButton);
    }

    public void FullReset(){
        orderID = 0;
        Condiments.clear();
        OrderList.clear();
        SetFoodOption(4);
        FoodIcon1.setIcon(PokeBowl);FoodIcon2.setIcon(FoodChoice2);
        FoodIcon3.setIcon(FoodChoice3);

        CheeseIcon.setIcon(CheeseCondiment);SweetOnionIcon.setIcon(SweetOnionCondiment);
        CrushedMixNutsIcon.setIcon(CrushedMixNutsCondiment);BBQIcon.setIcon(BBQCondiment);
        HoneyMustardIcon.setIcon(HoneyMustardCondiment);MayonnaiseIcon.setIcon(MayonnaiseCondiment);

        YesButtonIcon.setIcon(YesButton);NoButtonIcon.setIcon(NoButton);
        YesPleaseIcon.setIcon(YesPlease);NoThankYouIcon.setIcon(NoThankYou);
        DebitIcon.setIcon(DebitButton);CashIcon.setIcon(CashButton);
    }

    public void InsertIntoDatabase(){
        String Databaseid = "";
        if(FoodOrderdb.CountDatabase() > 1) {
            Databaseid = Integer.toString(Integer.parseInt(Integer.toString(FoodOrderdb.SelectDatabaseDesc()).substring(0,3)) + 1);
            for (int i = 0; i < OrderList.size(); i++){
                String OrderId = Integer.toString(OrderList.get(i).getID());
                FoodOrderdb.insertDatabase(Integer.parseInt( Databaseid + OrderId), OrderList.get(i).getFoodOption(),
                        OrderList.get(i).getCondimentsString(), OrderList.get(i).getPrice());
            }
        }
        else if(FoodOrderdb.CountDatabase() == 1){
            Databaseid = Integer.toString(FoodOrderdb.SelectDatabaseAsc() + 1);
            for (int i = 0; i < OrderList.size(); i++){
                String OrderId = Integer.toString(OrderList.get(i).getID());
                FoodOrderdb.insertDatabase(Integer.parseInt( Databaseid + OrderId), OrderList.get(i).getFoodOption(),
                        OrderList.get(i).getCondimentsString(), OrderList.get(i).getPrice());
            }
        }


    }


}


