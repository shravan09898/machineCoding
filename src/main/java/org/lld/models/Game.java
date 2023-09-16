package org.lld.models;

import org.lld.exceptions.InvalidBotCountException;
import org.lld.exceptions.InvalidDimensionException;
import org.lld.exceptions.InvalidDuplicateSymbolException;
import org.lld.exceptions.InvalidNoOfPlayersException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;

    private Game(List<Player> players, Board board, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.board = board;
        this.moves = new ArrayList<Move>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.winningStrategies = winningStrategies;
    }

    public static class Builder{
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimenson;

        public static Builder builder(){
            return new Builder();
        }

        public Builder() {
            this.players = new ArrayList<Player>();
            this.winningStrategies = new ArrayList<WinningStrategy>();
            this.dimenson = 0;
        }

        public void setPlayers(List<Player> players) {
            this.players = players;
        }

        public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
        }

        public void setDimenson(int dimenson) {
            this.dimenson = dimenson;
        }

        public void addPlayer(Player player){
            players.add(player);
        }

        public void addWinningStrategy(WinningStrategy winningStrategy){
            winningStrategies.add(winningStrategy);
        }

        private void validateBotCounts(){
            int botCount = 0;
            for(Player player : players){
                if(player.getPlayerType().equals(PlayerType.BOT))
                    botCount++;

                if(botCount>1)
                    //throw an exception
                    throw new InvalidBotCountException("We can't use more than 1 bot in a game");
            }
        }

        private void validateDimension(){
            if(dimenson<3 || dimenson>10){
                throw new InvalidDimensionException("Dimension shoule be >3 and <=10");
            }
        }

        private void validateNoOfPlayers(){
            if(players.size()!=dimenson-1)
                throw new InvalidNoOfPlayersException("NoOfPlayers should be one less than dimension");
        }

        private void validateUniqueSymbolForPlayers(){
            Set<Character> set = new HashSet<>();
            for(Player player : players){
                if(set.contains(player.getSymbol().getSymbolChar()))
                    throw new InvalidDuplicateSymbolException("Symbol is not unique");
                else
                    set.add(player.getSymbol().getSymbolChar());
            }
        }

        public void validate(){
            validateDimension();
            validateBotCounts();
            validateNoOfPlayers();
            validateUniqueSymbolForPlayers();
        }

        private Game build(){
            validate();
            return new Game(players, new Board(dimenson), winningStrategies);
        }
    }
}
