# Conway's Game of Life

## Description

This is a simple implementation of Conway's Game of Life in Java. It is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input. One interacts with the Game of Life by creating an initial configuration and observing how it evolves.

## Rules

The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells, each of which is in one of two possible states, alive or dead. Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent.

At each step in time, the following transitions occur:

- Any live cell with fewer than two live neighbours dies, as if by underpopulation.
- Any live cell with two or three live neighbours lives on to the next generation.
- Any live cell with more than three live neighbours dies, as if by overpopulation.
- Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

## Installation

Clone the repository and run the following command in the root directory:

```
$ gradle build
```

This will create a jar file in the build/libs directory.

## Usage

To run the program, use one of the following commands:

```
$ java -jar app/build/libs/game-of-life.jar
```

or

```
$ gradle run
```

Additionally, you can specify the following options:

```
$java -jar app/build/libs/game-of-life.jar [block] [blinker] [glider] [acorn] [all]
```

Each of these options will start the game with a different initial pattern. The default option with no parameters sets a random world with each cell having a 1/3 chance of being alive. The all option will run the game with all of the initial patterns.
