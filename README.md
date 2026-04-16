# MNKGamesCollection

[English](#english) | [Deutsch](#deutsch)

---

## English

This **collection of MNK-Games** is a Java console application for classic MNK games such as **Tic-Tac-Toe**, **Gomoku**, and **Connect Four**. It also allows custom game variants with configurable board sizes, win conditions, optional gravity and an optional bot opponent.

### Features

- Predefined game modes:
  - Tic-Tac-Toe
  - Gomoku
  - Connect Four
- Custom game mode
- Configurable board size
- Configurable win condition
- Optional gravity mode
- Optional bot opponent (Random moves)
- Console-based board rendering
- Input validation for smoother gameplay

### Available Game Modes

| Mode | Board Size | Win Condition | Gravity |
|------|------------|---------------|---------|
| Tic-Tac-Toe | 3 × 3 | 3 in a row | Disabled |
| Gomoku | 15 × 15 | 5 in a row | Disabled |
| Connect Four | 6 × 7 | 4 in a row | Enabled |
| Custom Game | Fully configurable | Fully configurable | Optional |

### Project Structure
```text
com.metzprojects.mnk
├── app         => application entry point
├── engine      => game flow and setup
├── logic       => game logic and win checking
├── domain      => Board, Player, Symbols, GameType
└── ui          => console menu, input, output, texts
```
### Gameplay

After starting the program, the player can choose a game mode.
Depending on the selection, the game is either initialized with preset values or configured manually.

In custom mode, the following settings can be defined:

- Number of rows
- Number of columns
- Number of symbols required in a row to win
- Whether gravity is enabled
- Whether to play against a bot or another human player

The game then runs until one player wins or the board is full. After that, a new round can be started immediately.

### Technical Notes

- Language: Java
- Version: 1.0
- Interface: Console / Terminal
- Minimum board size: 3
- Maximum board size: 20 
- Minimum win condition: 3 in a row
- Win conditions are checked horizontally, vertically, and diagonally
- In gravity mode, a piece automatically drops to the lowest free row in the selected column
- ASCII board availability for non-UTF-8 systems

### How to Run

1. Clone this repository
2. Open the project in your Java IDE
3. Make sure the package structure is correct
4. Run the Main class

### Work in Progress

- Smarter bot logic
- Additional unit tests
- GUI version
- Language settings
- Save/load functionality

### License

This project is licensed under the MIT License. See the LICENSE file for details.

Third-party components and generated wrapper files may be subject to their own licenses.

## Deutsch

Diese **MNK-Spielesammlung** ist eine Java-Konsolenanwendung für klassische MNK-Spiele wie **Tic-Tac-Toe**, **Gomoku** und **Connect Four**. Zusätzlich können eigene Spielvarianten mit frei konfigurierbarer Spielfeldgröße, Siegbedingung, optionaler Gravitation und optionalem Bot-Gegner erstellt werden.

### Features

- Vordefinierte Spielmodi:
  - Tic-Tac-Toe
  - Gomoku
  - Connect Four
- Benutzerdefinierter Spielmodus
- Frei wählbare Spielfeldgröße
- Frei wählbare Siegbedingung
- Optionaler Gravity-Modus
- Optionaler Bot-Gegner (Zufällige Züge)
- Konsolenbasierte Spielfeldanzeige
- Eingabevalidierung für eine stabilere Benutzerführung

### Verfügbare Spielmodi

| Modus | Spielfeld | Gewinnbedingung | Gravitation |
|------|-----------|---------------|-------------|
| Tic-Tac-Toe | 3 × 3 | 3 in einer Reihe | Deaktiviert |
| Gomoku | 15 × 15 | 5 in einer Reihe | Deaktiviert |
| Connect Four | 6 × 7 | 4 in einer Reihe | Aktiviert |
| Custom Game | Frei konfigurierbar | Frei konfigurierbar | Optional |

### Projektstruktur
```text
com.metzprojects.mnk
├── app         => Programmeinstieg
├── engine      => Spielablauf und Setup
├── logic       => Spiellogik und Gewinnerprüfung
├── domain      => Board, Player, Symbols, GameType
└── ui          => Konsolenmenü, Eingabe, Ausgabe, Texte
```
### Spielablauf

Nach dem Start des Programms kann ein Spielmodus ausgewählt werden.
Je nach Auswahl wird entweder ein vordefinierter Modus geladen oder ein eigenes Spiel konfiguriert.

Im Custom-Modus lassen sich folgende Werte festlegen:

- Anzahl der Zeilen
- Anzahl der Spalten
- Anzahl der benötigten Symbole in einer Reihe zum Gewinnen
- Aktivierung oder Deaktivierung von Gravitation
- Spiel gegen einen Bot oder gegen einen zweiten Spieler

Danach läuft das Spiel, bis ein Spieler gewinnt oder das Spielfeld voll ist. Anschließend kann direkt eine neue Runde gestartet werden.

### Technische Hinweise

- Programmiersprache: Java
- Version: 1.0
- Benutzeroberfläche: Konsole / Terminal
- Minimale Spielfeldgröße: 3
- Maximale Spielfeldgröße: 20 
- Minimale Gewinnbedingung: 3 in einer Reihe
- Gewinnbedingungen werden horizontal, vertikal und diagonal geprüft
- Im Gravity-Modus fällt ein Spielstein automatisch in die niedrigste freie Zeile der gewählten Spalte
- ASCII-Brettausgabe für Systeme ohne UTF-8-Unterstützung

### Datei Ausführen

1. Repository klonen
2. Projekt in einer Java-IDE öffnen
3. Darauf achten, dass die Paketstruktur korrekt ist
4. Die Klasse Main ausführen

### In Arbeit

- Verbesserte Bot-Logik 
- Zusätzliche Unit-Tests
- GUI-Version
- Sprachauswahl
- Spielstände speichern und laden

### Lizenz

Dieses Projekt steht unter der MIT-Lizenz. Siehe LICENSE-Datei für Details.

Drittanbieter-Komponenten und generierte Wrapper-Dateien können ihren eigenen Lizenzen unterliegen.
