package mlbbattingstats;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MlbPlayerStats {

	private JFrame frame;
	private JTextField searchTextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MlbPlayerStats window = new MlbPlayerStats();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MlbPlayerStats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 708, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel statsPanel = new JPanel();
		statsPanel.setBounds(1, 0, 289, 458);
		frame.getContentPane().add(statsPanel);
		statsPanel.setLayout(null);

		JLabel firstStatsLabel = new JLabel("");
		firstStatsLabel.setBounds(10, 33, 111, 14);
		statsPanel.add(firstStatsLabel);
		firstStatsLabel.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel secondStatsLabel = new JLabel("");
		secondStatsLabel.setBounds(10, 80, 111, 14);
		statsPanel.add(secondStatsLabel);
		secondStatsLabel.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel thirdStatsLabel = new JLabel("");
		thirdStatsLabel.setBounds(10, 127, 111, 14);
		statsPanel.add(thirdStatsLabel);
		thirdStatsLabel.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel fourthStatsLabel = new JLabel("");
		fourthStatsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		fourthStatsLabel.setBounds(10, 174, 111, 14);
		statsPanel.add(fourthStatsLabel);

		JLabel fifthStatsLabel = new JLabel("");
		fifthStatsLabel.setBounds(10, 221, 111, 14);
		statsPanel.add(fifthStatsLabel);

		JLabel sixthStatsLabel = new JLabel("");
		sixthStatsLabel.setBounds(10, 268, 111, 14);
		statsPanel.add(sixthStatsLabel);

		JLabel seventhStatsLabel = new JLabel("");
		seventhStatsLabel.setBounds(10, 315, 111, 14);
		statsPanel.add(seventhStatsLabel);

		JLabel eighthStatsLabel = new JLabel("");
		eighthStatsLabel.setBounds(10, 362, 111, 14);
		statsPanel.add(eighthStatsLabel);

		JLabel ninthStatsLabel = new JLabel("");
		ninthStatsLabel.setBounds(10, 409, 111, 14);
		statsPanel.add(ninthStatsLabel);

		JLabel firstStatsResultsLabel = new JLabel("");
		firstStatsResultsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		firstStatsResultsLabel.setBounds(131, 33, 111, 14);
		statsPanel.add(firstStatsResultsLabel);

		JLabel secondStatsResultsLabel = new JLabel("");
		secondStatsResultsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		secondStatsResultsLabel.setBounds(131, 80, 111, 14);
		statsPanel.add(secondStatsResultsLabel);

		JLabel thirdStatsResultsLabel = new JLabel("");
		thirdStatsResultsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		thirdStatsResultsLabel.setBounds(131, 127, 111, 14);
		statsPanel.add(thirdStatsResultsLabel);

		JLabel fourthStatsResultsLabel = new JLabel("");
		fourthStatsResultsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		fourthStatsResultsLabel.setBounds(131, 174, 111, 14);
		statsPanel.add(fourthStatsResultsLabel);

		JLabel fifthStatsResultsLabel = new JLabel("");
		fifthStatsResultsLabel.setBounds(131, 221, 111, 14);
		statsPanel.add(fifthStatsResultsLabel);

		JLabel sixthStatsResultsLabel = new JLabel("");
		sixthStatsResultsLabel.setBounds(131, 268, 111, 14);
		statsPanel.add(sixthStatsResultsLabel);

		JLabel seventhStatsResultsLabel = new JLabel("");
		seventhStatsResultsLabel.setBounds(131, 315, 111, 14);
		statsPanel.add(seventhStatsResultsLabel);

		JLabel eighthStatsResultsLabel = new JLabel("");
		eighthStatsResultsLabel.setBounds(131, 362, 111, 14);
		statsPanel.add(eighthStatsResultsLabel);

		JLabel ninthStatsResultsLabel = new JLabel("");
		ninthStatsResultsLabel.setBounds(131, 409, 111, 14);
		statsPanel.add(ninthStatsResultsLabel);

		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(403, 0, 289, 447);
		frame.getContentPane().add(searchPanel);
		searchPanel.setLayout(null);

		searchTextField = new JTextField();
		searchTextField.setBounds(10, 11, 269, 20);
		searchPanel.add(searchTextField);
		searchTextField.setColumns(10);

		JRadioButton seasonBattingRadioButton = new JRadioButton("Season Batting Stats");
		seasonBattingRadioButton.setSelected(true);
		buttonGroup.add(seasonBattingRadioButton);
		seasonBattingRadioButton.setBounds(105, 62, 174, 23);
		searchPanel.add(seasonBattingRadioButton);

		JRadioButton seasonPitchingRadioButton = new JRadioButton("Season Pitching Stats");
		buttonGroup.add(seasonPitchingRadioButton);
		seasonPitchingRadioButton.setBounds(105, 89, 174, 23);
		searchPanel.add(seasonPitchingRadioButton);

		JButton searchButton = new JButton("Search");
		searchButton.setBounds(10, 62, 89, 23);
		searchPanel.add(searchButton);

		JLabel playerNameLabel = new JLabel("");
		playerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerNameLabel.setBounds(10, 130, 269, 14);
		searchPanel.add(playerNameLabel);

		JLabel positionLabel = new JLabel("");
		positionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		positionLabel.setBounds(10, 155, 269, 14);
		searchPanel.add(positionLabel);

		JLabel teamLabel = new JLabel("");
		teamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamLabel.setBounds(10, 180, 269, 14);
		searchPanel.add(teamLabel);

		JLabel playerPhotoLabel = new JLabel("");
		playerPhotoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerPhotoLabel.setBounds(10, 223, 269, 213);
		searchPanel.add(playerPhotoLabel);

		// Search Action Listener
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MLBPlayer newPlayerByName = new MLBPlayer();
				JSONParser newParserById = new JSONParser();
				String playerName = searchTextField.getText();

				playerName = toCamelCase(playerName);

				searchTextField.setText(playerName);

				try {
					newPlayerByName = newParserById.jsonRequestByName(playerName);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (seasonBattingRadioButton.isSelected()) {

					setBattingLabels();

					try {
						if (newPlayerByName.getPlayersFound().equals("1")) {

							MLBPlayer newPlayerById = new MLBPlayer();

							String fullName = newPlayerByName.getFullNamePlayer();
							String position = newPlayerByName.getPosition();
							String team = newPlayerByName.getTeamName();

							newPlayerById = newParserById.seasonBattingJsonRequestById(newPlayerByName);

							newPlayerById.setFullNamePlayer(fullName);
							newPlayerById.setPosition(position);
							newPlayerById.setTeamName(team);

							if (newPlayerById.getPlayersFound().equals("1")) {

								firstStatsResultsLabel.setText(newPlayerById.getGamesPlayed());
								secondStatsResultsLabel.setText(newPlayerById.getAtBats());
								thirdStatsResultsLabel.setText(newPlayerById.getRuns());
								fourthStatsResultsLabel.setText(newPlayerById.getHits());
								fifthStatsResultsLabel.setText(newPlayerById.getHomeRuns());
								sixthStatsResultsLabel.setText(newPlayerById.getRunsBattedIn());
								seventhStatsResultsLabel.setText(newPlayerById.getStolenBases());
								eighthStatsResultsLabel.setText(newPlayerById.getBattingAvg());
								ninthStatsResultsLabel.setText(newPlayerById.getOnBasePlusSlugging());

								playerNameLabel.setText(newPlayerById.getFullNamePlayer());
								positionLabel.setText(newPlayerById.getPosition());
								teamLabel.setText(newPlayerById.getTeamName());

								setPlayerHeadShot(newPlayerById);

							} else {

								blankLabels();

								playerNameLabel.setText(newPlayerById.getFullNamePlayer() + " has no batting stats.");
								setPlayerHeadShot(newPlayerById);

							}

						} else {

							blankLabels();
							playerNameLabel.setText(playerName + " not found. Try again.");
							removePlayerHeadShot();
						}

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (seasonPitchingRadioButton.isSelected()) {

					setPitchingLabels();

					try {
						if (newPlayerByName.getPlayersFound().equals("1")) {

							MLBPlayer newPlayerById = new MLBPlayer();

							String fullName = newPlayerByName.getFullNamePlayer();
							String position = newPlayerByName.getPosition();
							String team = newPlayerByName.getTeamName();

							newPlayerById = newParserById.seasonPitchingJsonRequestById(newPlayerByName);

							newPlayerById.setFullNamePlayer(fullName);
							newPlayerById.setPosition(position);
							newPlayerById.setTeamName(team);

							if (newPlayerByName.getPlayersFound().equals("1")) {

								firstStatsResultsLabel.setText(newPlayerById.getGamesPitched());
								secondStatsResultsLabel.setText(newPlayerById.getWins());
								thirdStatsResultsLabel.setText(newPlayerById.getLosses());
								fourthStatsResultsLabel.setText(newPlayerById.getWinPercentage());
								fifthStatsResultsLabel.setText(newPlayerById.getEarnedRuns());
								sixthStatsResultsLabel.setText(newPlayerById.getGamesStarted());
								seventhStatsResultsLabel.setText(newPlayerById.getSaves());
								eighthStatsResultsLabel.setText(newPlayerById.getInningsPitched());
								ninthStatsResultsLabel.setText(newPlayerById.getStrikeOuts());

								playerNameLabel.setText(newPlayerById.getFullNamePlayer());
								positionLabel.setText(newPlayerById.getPosition());
								teamLabel.setText(newPlayerById.getTeamName());

								setPlayerHeadShot(newPlayerById);

							} else {

								blankLabels();
								playerNameLabel.setText(newPlayerById.getFullNamePlayer() + " has no pitching stats.");
								setPlayerHeadShot(newPlayerById);
							}

						} else {

							blankLabels();
							playerNameLabel.setText(playerName + " not found. Try again.");
							removePlayerHeadShot();
						}

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}

			private void setPitchingLabels() {
				firstStatsLabel.setText("Games Pitched:");
				secondStatsLabel.setText("Wins:");
				thirdStatsLabel.setText("Losses:");
				fourthStatsLabel.setText("Win %:");
				fifthStatsLabel.setText("E.R.A.:");
				sixthStatsLabel.setText("Games Started:");
				seventhStatsLabel.setText("Saves:");
				eighthStatsLabel.setText("Innings Pitched:");
				ninthStatsLabel.setText("SOs:");

			}

			private void setBattingLabels() {
				firstStatsLabel.setText("Games Played:");
				secondStatsLabel.setText("At Bats:");
				thirdStatsLabel.setText("Runs:");
				fourthStatsLabel.setText("Hits:");
				fifthStatsLabel.setText("HRs:");
				sixthStatsLabel.setText("RBIs:");
				seventhStatsLabel.setText("SBs:");
				eighthStatsLabel.setText("AVG:");
				ninthStatsLabel.setText("OBS: ");

			}

			private void blankLabels() {
				firstStatsResultsLabel.setText("");
				secondStatsResultsLabel.setText("");
				thirdStatsResultsLabel.setText("");
				fourthStatsResultsLabel.setText("");
				fifthStatsResultsLabel.setText("");
				sixthStatsResultsLabel.setText("");
				seventhStatsResultsLabel.setText("");
				eighthStatsResultsLabel.setText("");
				ninthStatsResultsLabel.setText("");

				playerNameLabel.setText("");
				positionLabel.setText("");
				teamLabel.setText("");

			}

			private void setPlayerHeadShot(MLBPlayer playerId) {
				String playerHeadshotUrl = "https://securea.mlb.com/mlb/images/players/head_shot/"
						+ playerId.getId() + ".jpg";

				URL pictureURL = null;
				try {
					pictureURL = new URL(playerHeadshotUrl);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Image playerHeadshot = null;
				try {
					playerHeadshot = ImageIO.read(pictureURL.openStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				playerPhotoLabel.setIcon(new ImageIcon(playerHeadshot));
				searchPanel.add(playerPhotoLabel);
			}

			private void removePlayerHeadShot() {
				playerPhotoLabel.setIcon(null);
				searchPanel.add(playerPhotoLabel);
			}

		});

	}

	// To print the player's name with Upper Case at the beginning
	public String toCamelCase(String nameGiven) {
		if (nameGiven == null)
			return null;

		final StringBuilder newFullName = new StringBuilder(nameGiven.length());

		for (final String name : nameGiven.split(" ")) {
			if (!name.isEmpty()) {
				newFullName.append(Character.toUpperCase(name.charAt(0)));
				newFullName.append(name.substring(1).toLowerCase());
			}
			if (!(newFullName.length() == nameGiven.length()))
				newFullName.append(" ");
		}

		return newFullName.toString();
	}
}
