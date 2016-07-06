package com.fujitsu.fs.javalab.poll.webapp.hsqldb;

import com.fujitsu.fs.javalab.poll.webapp.model.Poll;
import com.fujitsu.fs.javalab.poll.webapp.model.PollChoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Ekaterina on 01.05.2016.
 */
public class PollRepository {

    public static ArrayList<Poll> getPolls() throws SQLException, ClassNotFoundException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from  POLL");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Poll> polls = new ArrayList<>();
        while (resultSet.next()) {
            Poll poll = new Poll();
            poll.setId(resultSet.getLong("id"));
            poll.setTitle(resultSet.getString("title"));
            polls.add(poll);

        }
        return polls;

    }

    public static ArrayList<String> getPollChoicesTexsts(Long pollid) throws SQLException, ClassNotFoundException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select CHOICE_TEXT FROM POLL_CHOICE WHERE POLL_ID = ?");
        preparedStatement.setLong(1, pollid);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<String> choicetexts = new ArrayList<>();
        while (resultSet.next()) {
            String choicetext = resultSet.getString(1);
            choicetexts.add(choicetext);

        }
        return choicetexts;
    }

    public static void changeVotes(String variant) throws SQLException, ClassNotFoundException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE POLL_CHOICE SET VOTES = VOTES + 1 WHERE CHOICE_TEXT = ?");
        preparedStatement.setString(1, variant);
        preparedStatement.execute();
    }

    public static ArrayList<PollChoice> getPollChoices(Long pollid) throws SQLException, ClassNotFoundException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * FROM POLL_CHOICE WHERE POLL_ID = ?");
        preparedStatement.setLong(1, pollid);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<PollChoice> choicetexts = new ArrayList<>();
        while (resultSet.next()) {
            PollChoice pollChoice = new PollChoice();
            pollChoice.setId(resultSet.getLong("id"));
            pollChoice.setChoice_text(resultSet.getString("choice_text"));
            pollChoice.setVotes(resultSet.getInt("votes"));
            pollChoice.setPoll_id(pollid);
            choicetexts.add(pollChoice);

        }
        return choicetexts;
    }
}
