package mlbbattingstats;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class JSONParser {

	public MLBPlayer jsonRequestByName(String playerName) throws Exception {

		// MLBPlayer created based on given name.
		String playerNameFormatted = playerName.strip();
		playerNameFormatted = toCamelCase(playerNameFormatted);
		String playerNameSearched = playerName.strip().replaceAll(" ", "%25").toLowerCase();
		MLBPlayer newPlayer = new MLBPlayer();

		// Build the URL
		String playerInfoByNameUrl = "http://lookup-service-prod.mlb.com/json/named.search_player_all.bam?sport_code=%27mlb%27&active_sw=%27Y%27&name_part=%27"
				+ playerNameSearched + "%27";
		URL urlObject = new URL(playerInfoByNameUrl);
		HttpURLConnection httpConnection = (HttpURLConnection) urlObject.openConnection();

		// Optional default is GET
		httpConnection.setRequestMethod("GET");

		// Add request header
		httpConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = httpConnection.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + playerInfoByNameUrl);
		System.out.println("Response Code : " + responseCode);
		BufferedReader inBufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = inBufferedReader.readLine()) != null) {
			response.append(inputLine);
		}
		inBufferedReader.close();

		// Read JSON response
		JSONObject jsonResponse = new JSONObject(response.toString());

		// Check if player is found
		String playersFound = jsonResponse.getJSONObject("search_player_all").getJSONObject("queryResults")
				.get("totalSize").toString();

		if (playersFound.equals("1")) {
			String fullNamePlayer = jsonResponse.getJSONObject("search_player_all").getJSONObject("queryResults")
					.getJSONObject("row").get("name_display_first_last").toString();
			String position = jsonResponse.getJSONObject("search_player_all").getJSONObject("queryResults")
					.getJSONObject("row").get("position").toString();
			String teamName = jsonResponse.getJSONObject("search_player_all").getJSONObject("queryResults")
					.getJSONObject("row").get("team_full").toString();
			String playerId = jsonResponse.getJSONObject("search_player_all").getJSONObject("queryResults")
					.getJSONObject("row").get("player_id").toString();

			newPlayer.setFullNamePlayer(fullNamePlayer);
			newPlayer.setPosition(position);
			newPlayer.setTeamName(teamName);
			newPlayer.setId(playerId);
			newPlayer.setPlayersFound(playersFound);

		} else {
			newPlayer.setPlayersFound(playersFound);
		}

		return newPlayer;

	}

	public MLBPlayer seasonBattingJsonRequestById(MLBPlayer playerId) throws Exception {

		// MLBPlayer to parse the data into.
		String playerIdSearched = playerId.getId().strip().replaceAll(" ", "%25").toLowerCase();
		String seasonYear = "2019";

		// Build the URL
		String seasonBattingByIdUrl = "http://lookup-service-prod.mlb.com/json/named.sport_hitting_tm.bam?league_list_id=%27mlb%27&game_type=%27R%27&season=%27"
				+ seasonYear + "%27&player_id=%27" + playerIdSearched + "%27";
		URL urlObject = new URL(seasonBattingByIdUrl);
		HttpURLConnection httpConnection = (HttpURLConnection) urlObject.openConnection();

		// Optional default is GET
		httpConnection.setRequestMethod("GET");

		// Add request header
		httpConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = httpConnection.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + seasonBattingByIdUrl);
		System.out.println("Response Code : " + responseCode);
		BufferedReader inBufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = inBufferedReader.readLine()) != null) {
			response.append(inputLine);
		}
		inBufferedReader.close();

		// Read JSON response
		JSONObject jsonResponse = new JSONObject(response.toString());

		// Check if player has Batting Stats
		String checkBattingStats = jsonResponse.getJSONObject("sport_hitting_tm").getJSONObject("queryResults")
				.get("totalSize").toString();

		if (checkBattingStats.equals("1")) {

			String gamesPlayed = jsonResponse.getJSONObject("sport_hitting_tm").getJSONObject("queryResults")
					.getJSONObject("row").get("g").toString();
			String atBats = jsonResponse.getJSONObject("sport_hitting_tm").getJSONObject("queryResults")
					.getJSONObject("row").get("ab").toString();
			String runs = jsonResponse.getJSONObject("sport_hitting_tm").getJSONObject("queryResults")
					.getJSONObject("row").get("r").toString();
			String hits = jsonResponse.getJSONObject("sport_hitting_tm").getJSONObject("queryResults")
					.getJSONObject("row").get("h").toString();
			String homeRuns = jsonResponse.getJSONObject("sport_hitting_tm").getJSONObject("queryResults")
					.getJSONObject("row").get("hr").toString();
			String runsBattedIn = jsonResponse.getJSONObject("sport_hitting_tm").getJSONObject("queryResults")
					.getJSONObject("row").get("rbi").toString();
			String stolenBases = jsonResponse.getJSONObject("sport_hitting_tm").getJSONObject("queryResults")
					.getJSONObject("row").get("sb").toString();
			String battingAvg = jsonResponse.getJSONObject("sport_hitting_tm").getJSONObject("queryResults")
					.getJSONObject("row").get("avg").toString();
			String onBasePlusSlugging = jsonResponse.getJSONObject("sport_hitting_tm").getJSONObject("queryResults")
					.getJSONObject("row").get("ops").toString();

			playerId.setGamesPlayed(gamesPlayed);
			playerId.setAtBats(atBats);
			playerId.setRuns(runs);
			playerId.setHits(hits);
			playerId.setHomeRuns(homeRuns);
			playerId.setRunsBattedIn(runsBattedIn);
			playerId.setStolenBases(stolenBases);
			playerId.setBattingAvg(battingAvg);
			playerId.setOnBasePlusSlugging(onBasePlusSlugging);

			playerId.setPlayersFound(checkBattingStats);

		} else {
			System.out.println("Player have no batting stats.");
			playerId.setPlayersFound("2");
		}

		return playerId;

	}

	public MLBPlayer seasonPitchingJsonRequestById(MLBPlayer playerId) throws Exception {

		// MLBPlayer to parse the data into.
		String playerIdSearched = playerId.getId().strip().replaceAll(" ", "%25").toLowerCase();
		String seasonYear = "2019";

		// Build the URL
		String seasonPitchingByIdUrl = "http://lookup-service-prod.mlb.com/json/named.sport_pitching_tm.bam?league_list_id='mlb'&game_type='R'&season=%27"
				+ seasonYear + "%27&player_id=%27" + playerIdSearched + "%27";
		URL urlObject = new URL(seasonPitchingByIdUrl);
		HttpURLConnection httpConnection = (HttpURLConnection) urlObject.openConnection();

		// Optional default is GET
		httpConnection.setRequestMethod("GET");

		// Add request header
		httpConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = httpConnection.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + seasonPitchingByIdUrl);
		System.out.println("Response Code : " + responseCode);
		BufferedReader inBufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = inBufferedReader.readLine()) != null) {
			response.append(inputLine);
		}
		inBufferedReader.close();

		// Read JSON response
		JSONObject jsonResponse = new JSONObject(response.toString());

		// Check if the player has Pitching Stats
		String checkPitchingStats = jsonResponse.getJSONObject("sport_pitching_tm").getJSONObject("queryResults")
				.get("totalSize").toString();

		if (checkPitchingStats.equals("1")) {

			String gamesPitched = jsonResponse.getJSONObject("sport_pitching_tm").getJSONObject("queryResults")
					.getJSONObject("row").get("g").toString();
			String wins = jsonResponse.getJSONObject("sport_pitching_tm").getJSONObject("queryResults")
					.getJSONObject("row").get("w").toString();
			String losses = jsonResponse.getJSONObject("sport_pitching_tm").getJSONObject("queryResults")
					.getJSONObject("row").get("l").toString();
			String winPercentage = jsonResponse.getJSONObject("sport_pitching_tm").getJSONObject("queryResults")
					.getJSONObject("row").get("wpct").toString();
			String earnedRuns = jsonResponse.getJSONObject("sport_pitching_tm").getJSONObject("queryResults")
					.getJSONObject("row").get("era").toString();
			String gamesStarted = jsonResponse.getJSONObject("sport_pitching_tm").getJSONObject("queryResults")
					.getJSONObject("row").get("gs").toString();
			String saves = jsonResponse.getJSONObject("sport_pitching_tm").getJSONObject("queryResults")
					.getJSONObject("row").get("sv").toString();
			String inningsPitched = jsonResponse.getJSONObject("sport_pitching_tm").getJSONObject("queryResults")
					.getJSONObject("row").get("ip").toString();
			String strikeOuts = jsonResponse.getJSONObject("sport_pitching_tm").getJSONObject("queryResults")
					.getJSONObject("row").get("so").toString();

			playerId.setGamesPitched(gamesPitched);
			playerId.setWins(wins);
			playerId.setLosses(losses);
			playerId.setWinPercentage(winPercentage);
			playerId.setEarnedRuns(earnedRuns);
			playerId.setGamesStarted(gamesStarted);
			playerId.setSaves(saves);
			playerId.setInningsPitched(inningsPitched);
			playerId.setStrikeOuts(strikeOuts);

			playerId.setPlayersFound(checkPitchingStats);
		} else {
			System.out.println("Player have no pitching stats.");
			playerId.setPlayersFound("2");
		}

		return playerId;

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