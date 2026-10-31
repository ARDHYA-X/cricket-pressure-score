# Cricket Pressure Score

Cricket is the 2nd biggest sport in the world, and every T20 match has a moment where one batter or bowler is carrying the whole game on their shoulders. Existing measures only score the team, never the individual player. This project puts a number on it.

## Project Goal
A Java program that pulls live T20 data and calculates a pressure score from 2 to 9 for the batter at the crease during a chase.

## MVP Scope
- Pull T20 match data from the Cricket Data API
- Batter pressure formula, chase mode only (expected vs actual runs, running pressure bucket with simple decay, situation multiplier)
- Hard-coded stakes table (4 tiers)
- Career strike-rate baseline per player, with league-average fallback
- Print the 2-9 pressure score in the terminal during the chase

## Future Plans
- Bowler pressure formula
- Website showing scores live
- Batting-first mode (par-score logic)
- Recent-form blending and full recency-weighted decay
- Rivalry vs tournament-round split for stakes

## Tech Stack
- Java (HttpClient, Gson)
- JSON files for the stakes table and player baselines
- Cricket Data API (cricketdata.org)

## Design Docs
- [Eisenhower Matrix](docs/Eisenhower%20Matrix.pdf)
- System diagram: [System diagram](docs/System%20Diagram.png)
