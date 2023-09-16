package org.lld.models;

import org.lld.exceptions.InvalidCellToUseException;

import java.util.Scanner;

public class Player {
    private long id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private Scanner scanner;

    public Player(long id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }

    public Move makeMove(Board board){
        System.out.println("Please enter row and col for the move");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        //Validate the move and throw exception

        Cell cell = new Cell(row, col, this);
        if(cell.getCellState()==CellState.BLOCKED){
            throw new InvalidCellToUseException("This cell is blocked, DO NOT USE");
        }
        else if(cell.getCellState()==CellState.OCCUPIED){
            throw new InvalidCellToUseException("This cell is occupied, DO NOT USE");
        }
        return new Move(cell, this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
