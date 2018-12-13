package ui;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class SearchUI extends JFrame {
	JTextField txtNumberOfFilms;
	JButton btnSearch;

	// Check box Title Type
	Checkbox ckbFeatureFilm, ckbTVMovie, ckbTVSeries, ckbTVEpisode,
			 ckbTVSpecial, ckbMiniSeries, ckbDocumentary, ckbVideoGame,
			 ckbShortFilm, ckbVideo, ckbTVShort;

	// Check box Genres
	Checkbox ckbAction, ckbAdventure, ckbAnimation, ckbBiography,
			 ckbComedy, ckbCrime, ckbDrama, ckbFamily, ckbFantasy,
			 ckbGameShow, ckbHistory, ckbHorror, ckbMusic, ckbMusical,
			 ckbMystery, ckbNews, ckbRealityTV, ckbRomance, ckbSport,
			 ckbTalkShow, ckbThriller, ckbWar;

	// Check box Companies
	Checkbox ckb20thCenturyFox, ckbSony, ckbDreamWork, ckbMGM,
			 ckbParamount, ckbUniversal, ckbWaltDisney, ckbWarnerBros;

	// Date
	JTextField txtDateFrom, txtDateTo;

	public SearchUI(String title)
	{
		super(title);
		addControls();
		addEvents();
	}

	public void addControls()
	{
		Container con = getContentPane();
		con.setLayout(new BorderLayout());

		/* Top */
		JPanel pnTop = new JPanel();
		pnTop.setLayout(new GridLayout(2, 2));
		con.add(pnTop, BorderLayout.CENTER);

		// Create Border Top
		Border boderTop = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titleBorderBottom = new TitledBorder(boderTop, "Lựa chọn các tiêu chí của phim");
		titleBorderBottom.setTitleFont(new Font("Arial", Font.BOLD, 20));
		titleBorderBottom.setTitleJustification(TitledBorder.CENTER);
		titleBorderBottom.setTitleColor(Color.BLUE);
		pnTop.setBorder(titleBorderBottom);

		// Create panel TopLeft
		JPanel pnTopLeft = new JPanel();
		pnTopLeft.setLayout(new GridLayout(3, 4));
		pnTop.add(pnTopLeft);

		Border borderTopLeft = BorderFactory.createLineBorder(Color.GRAY);
		TitledBorder titleBorderTopLeft = new TitledBorder(borderTopLeft, "Title Type");
		titleBorderTopLeft.setTitleFont(new Font("Arial", Font.BOLD, 15));
		titleBorderTopLeft.setTitleJustification(TitledBorder.CENTER);
		titleBorderTopLeft.setTitleColor(Color.BLUE);
		pnTopLeft.setBorder(titleBorderTopLeft);

		ckbFeatureFilm = new Checkbox("Feature Film");
		ckbTVMovie     = new Checkbox("TV Movie");
		ckbTVSeries    = new Checkbox("TV Series");
		ckbTVEpisode   = new Checkbox("TV Episode");
		ckbTVSpecial   = new Checkbox("TV Special");
		ckbMiniSeries  = new Checkbox("Mini Series");
		ckbDocumentary = new Checkbox("Documentary");
		ckbVideoGame   = new Checkbox("Video Game");
		ckbShortFilm   = new Checkbox("Short Film");
		ckbVideo       = new Checkbox("Video");
		ckbTVShort     = new Checkbox("TV Short");

		pnTopLeft.add(ckbFeatureFilm); pnTopLeft.add(ckbTVMovie);
		pnTopLeft.add(ckbTVSeries);    pnTopLeft.add(ckbTVEpisode);
		pnTopLeft.add(ckbTVSpecial);   pnTopLeft.add(ckbMiniSeries);
		pnTopLeft.add(ckbDocumentary); pnTopLeft.add(ckbVideoGame);
		pnTopLeft.add(ckbShortFilm);   pnTopLeft.add(ckbVideo);
		pnTopLeft.add(ckbTVShort);

		// Create panel BottomTopLeft
		JPanel pnBottomTopLeft= new JPanel();
		pnBottomTopLeft.setLayout(new BoxLayout(pnBottomTopLeft, BoxLayout.Y_AXIS));
		pnTop.add(pnBottomTopLeft);

		Border borderBottomTopLeft = BorderFactory.createLineBorder(Color.GRAY);
		TitledBorder titleBorderBottomTopLeft = new TitledBorder(borderBottomTopLeft, "Release Date");
		titleBorderBottomTopLeft.setTitleFont(new Font("Arial", Font.BOLD, 15));
		titleBorderBottomTopLeft.setTitleJustification(TitledBorder.CENTER);
		titleBorderBottomTopLeft.setTitleColor(Color.BLUE);
		pnBottomTopLeft.setBorder(titleBorderBottomTopLeft);

		JPanel pnTopReleaseDate = new JPanel();
		pnTopReleaseDate.setLayout(new GridBagLayout());
		JLabel lblDateFrom = new JLabel("Date From (yyyy-mm-dd): ");
		txtDateFrom = new JTextField(20);
		pnTopReleaseDate.add(lblDateFrom);
		pnTopReleaseDate.add(txtDateFrom);
		pnBottomTopLeft.add(pnTopReleaseDate);
		
		JPanel pnBottomReleaseDate = new JPanel();
		pnBottomReleaseDate.setLayout(new GridBagLayout());
		JLabel lblDateTo = new JLabel("To (yyyy-mm-dd): ");
		txtDateTo = new JTextField(20);
		pnBottomReleaseDate.add(lblDateTo);
		pnBottomReleaseDate.add(txtDateTo);
		pnBottomTopLeft.add(pnBottomReleaseDate);
		
		lblDateTo.setPreferredSize(lblDateFrom.getPreferredSize());
		
		// Create panel TopRight 
		JPanel pnTopRight = new JPanel();
		pnTopRight.setLayout(new GridLayout(5, 5));
		pnTop.add(pnTopRight);

		Border borderTopRight = BorderFactory.createLineBorder(Color.GRAY);
		TitledBorder titleBorderTopRight = new TitledBorder(borderTopRight, "Genres");
		titleBorderTopRight.setTitleFont(new Font("Arial", Font.BOLD, 15));
		titleBorderTopRight.setTitleJustification(TitledBorder.CENTER);
		titleBorderTopRight.setTitleColor(Color.BLUE);
		pnTopRight.setBorder(titleBorderTopRight);

		ckbAction     = new Checkbox("Action");
		ckbAdventure  = new Checkbox("Adventure");
		ckbAnimation  = new Checkbox("Animation");
		ckbBiography  = new Checkbox("Biography");
		ckbComedy     = new Checkbox("Comedy");
		ckbCrime      = new Checkbox("Crime");
		ckbDrama      = new Checkbox("Drama");
		ckbFamily     = new Checkbox("Family");
		ckbFantasy    = new Checkbox("Fantasy");
		ckbGameShow   = new Checkbox("Game show");
		ckbHistory    = new Checkbox("History");
		ckbHorror     = new Checkbox("Horror");
		ckbMusic      = new Checkbox("Music");
		ckbMusical    = new Checkbox("Musical");
		ckbMystery    = new Checkbox("Mystery");
		ckbNews       = new Checkbox("News");
		ckbRealityTV  = new Checkbox("Reality TV");
		ckbRomance    = new Checkbox("Romance");
		ckbSport      = new Checkbox("Sport");
		ckbTalkShow   = new Checkbox("Talk show");
		ckbThriller   = new Checkbox("Thriller");
		ckbWar        = new Checkbox("War");

		pnTopRight.add(ckbAction);    pnTopRight.add(ckbAdventure);
		pnTopRight.add(ckbAnimation); pnTopRight.add(ckbBiography);
		pnTopRight.add(ckbComedy);    pnTopRight.add(ckbCrime);
		pnTopRight.add(ckbDrama);     pnTopRight.add(ckbFamily);
		pnTopRight.add(ckbFantasy);   pnTopRight.add(ckbGameShow);
		pnTopRight.add(ckbHistory);   pnTopRight.add(ckbHorror);
		pnTopRight.add(ckbMusic);     pnTopRight.add(ckbMusical);
		pnTopRight.add(ckbMystery);   pnTopRight.add(ckbNews);
		pnTopRight.add(ckbRealityTV); pnTopRight.add(ckbRomance);
		pnTopRight.add(ckbSport);     pnTopRight.add(ckbTalkShow);
		pnTopRight.add(ckbThriller);  pnTopRight.add(ckbWar);





		// Create panel BottomTopRight
		JPanel pnBottomTopRight = new JPanel();
		pnBottomTopRight.setLayout(new GridLayout(3, 3));
		pnTop.add(pnBottomTopRight);

		Border borderBottomTopRight = BorderFactory.createLineBorder(Color.GRAY);
		TitledBorder titleBorderBottomTopRight = new TitledBorder(borderBottomTopRight, "Companies");
		titleBorderBottomTopRight.setTitleFont(new Font("Arial", Font.BOLD, 15));
		titleBorderBottomTopRight.setTitleJustification(TitledBorder.CENTER);
		titleBorderBottomTopRight.setTitleColor(Color.BLUE);
		pnBottomTopRight.setBorder(titleBorderBottomTopRight);
		
		ckb20thCenturyFox = new Checkbox("20th Century Fox");
		ckbSony			  = new Checkbox("Sony");
		ckbDreamWork      = new Checkbox("Dream Work");
		ckbMGM            = new Checkbox("MGM");
		ckbParamount      = new Checkbox("Paramount");
		ckbUniversal      = new Checkbox("Universal");
		ckbWaltDisney     = new Checkbox("Walt Disney");
		ckbWarnerBros     = new Checkbox("Warner Bros");
		
		pnBottomTopRight.add(ckb20thCenturyFox); pnBottomTopRight.add(ckbSony);
		pnBottomTopRight.add(ckbDreamWork);      pnBottomTopRight.add(ckbMGM);
		pnBottomTopRight.add(ckbParamount);      pnBottomTopRight.add(ckbUniversal);
		pnBottomTopRight.add(ckbWaltDisney);     pnBottomTopRight.add(ckbWarnerBros);

		/* Bottom */
		JPanel pnBottom = new JPanel();
		pnBottom.setLayout(new BoxLayout(pnBottom, BoxLayout.Y_AXIS));
		pnBottom.setPreferredSize(new Dimension(0, 100));
		pnBottom.setBackground(Color.blue);
		con.add(pnBottom, BorderLayout.SOUTH);

		JPanel pnText = new JPanel();
		pnText.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblNumberOfFilms = new JLabel("Số lượng phim cần tìm (<= 50): ");
		lblNumberOfFilms.setFont(new Font("Arial", Font.BOLD, 20));
		txtNumberOfFilms = new JTextField(10);
		txtNumberOfFilms.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		pnText.add(lblNumberOfFilms);
		pnText.add(txtNumberOfFilms);
		pnBottom.add(pnText);

		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.CENTER));
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Arial", Font.BOLD, 20));
		pnButton.add(btnSearch);
		pnBottom.add(pnButton);
	}

	public void addEvents()
	{
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handingInfoSearch();
			}
		});
	}

	protected void handingInfoSearch() {
		if(txtNumberOfFilms.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Rỗng", "Empty", JOptionPane.WARNING_MESSAGE);
		}
		int num = Integer.parseInt(txtNumberOfFilms.getText());
		if(num > 50 || num <= 0)
		{
			JOptionPane.showMessageDialog(null, "Bạn đã nhập sai !", "Error", JOptionPane.WARNING_MESSAGE);
		}

		
	}

	public void showWindow()
	{
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
}
