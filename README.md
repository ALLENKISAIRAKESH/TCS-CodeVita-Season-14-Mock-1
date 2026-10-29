# 🏆 TCS CodeVita Season 14 — Mock 1 Solutions

> All 6 problems solved in **Python** and **Java** with detailed, beginner-friendly explanations.

[![Language](https://img.shields.io/badge/Python-3.x-blue?logo=python)](https://python.org)
[![Language](https://img.shields.io/badge/Java-17+-orange?logo=openjdk)](https://openjdk.org)
[![Contest](https://img.shields.io/badge/TCS%20CodeVita-Season%2014-red)](https://www.tcscodevita.com)

---

## 📋 Problem List

| # | Problem | Difficulty | Key Concept | Solution |
|---|---------|-----------|-------------|----------|
| A | [**RasikhBox**](problems/A_RasikhBox/) | 🟢 Easy | Grid rotation + Gravity simulation | [Python](problems/A_RasikhBox/solution.py) · [Java](problems/A_RasikhBox/Solution.java) |
| B | [**MaxMatchBox**](problems/B_MaxMatchBox/) | 🟡 Medium | 2D Prefix Sums + Geometry | [Python](problems/B_MaxMatchBox/solution.py) · [Java](problems/B_MaxMatchBox/Solution.java) |
| C | [**SmallestRegion**](problems/C_SmallestRegion/) | 🟢 Easy | Greedy gap finding | [Python](problems/C_SmallestRegion/solution.py) · [Java](problems/C_SmallestRegion/Solution.java) |
| D | [**GravityGlide**](problems/D_GravityGlide/) | 🟡 Medium | Physics simulation | [Python](problems/D_GravityGlide/solution.py) · [Java](problems/D_GravityGlide/Solution.java) |
| E | [**ShapeCount**](problems/E_ShapeCount/) | 🔴 Hard | Coordinate compression + Bitmasks | [Python](problems/E_ShapeCount/solution.py) · [Java](problems/E_ShapeCount/Solution.java) |
| F | [**PickSmartPlayWise**](problems/F_PickSmartPlayWise/) | 🔴 Hard | Planar graph cycle detection + Geometry | [Python](problems/F_PickSmartPlayWise/solution.py) · [Java](problems/F_PickSmartPlayWise/Solution.java) |

---

## 🧒 Quick Summary (ELI5 — Explain Like I'm 5)

### A · RasikhBox — *"The Tilting Sand Toy"*
You have a box with stones. Tilt it left or right and the stones fall due to gravity. Show the final arrangement!

### B · MaxMatchBox — *"The Pizza Box Problem"*
Fold a flat cardboard shape into a box. Find the perfect folding height for the biggest box volume!

### C · SmallestRegion — *"Folding a Napkin"*
Fold a paper with stickers on it (without folding through any sticker). After unfolding, find the smallest rectangle created by the fold lines!

### D · GravityGlide — *"Pinball Machine"*
A ball drops onto diagonal ramps, slides down, gets stuck at junctions (costs energy to escape), and finally lands. Find where it stops!

### E · ShapeCount — *"Rectangle Hunter"*
Given horizontal and vertical lines on a grid, count how many rectangles can be formed where all 4 sides are fully covered by the lines!

### F · PickSmartPlayWise — *"Stick Game: Kalyan vs Computer"*
Sticks on a plane form shapes. Kalyan takes the closed polygon, Computer reshapes leftovers into a circle. Who encloses more area?

---

## 📁 Repository Structure

```
TCS-CodeVita-S14-Mock1/
├── README.md                          ← You are here!
├── problems/
│   ├── A_RasikhBox/
│   │   ├── README.md                  ← Detailed explanation
│   │   ├── problem.png               ← Problem screenshot
│   │   ├── solution.py               ← Python solution
│   │   └── Solution.java             ← Java solution
│   ├── B_MaxMatchBox/
│   │   ├── README.md
│   │   ├── problem.png
│   │   ├── solution.py
│   │   └── Solution.java
│   ├── C_SmallestRegion/
│   │   ├── README.md
│   │   ├── problem.png
│   │   ├── solution.py
│   │   └── Solution.java
│   ├── D_GravityGlide/
│   │   ├── README.md
│   │   ├── problem.png
│   │   ├── solution.py
│   │   └── Solution.java
│   ├── E_ShapeCount/
│   │   ├── README.md
│   │   ├── problem.png
│   │   ├── solution.py
│   │   └── Solution.java
│   └── F_PickSmartPlayWise/
│       ├── README.md
│       ├── problem.png
│       ├── solution.py
│       └── Solution.java
```

---

## 🚀 How to Run

### Python
```bash
cd problems/A_RasikhBox
python solution.py < input.txt
```

### Java
```bash
cd problems/A_RasikhBox
javac Solution.java
java Solution < input.txt
```

> **Note:** All solutions read from standard input (stdin). Pipe your test case file or type input manually.

---

## 🧠 Concepts Used Across Problems

| Concept | Used In |
|---------|---------|
| Grid/Matrix Manipulation | A, B |
| Coordinate Compression | E |
| Bitmask Operations | E |
| 2D Prefix Sums | B |
| Planar Graph + Cycle Detection | F |
| Shoelace Formula (Polygon Area) | F |
| Line-Line Intersection | D, F |
| Simulation | A, D |
| Greedy | C |
| Ray Casting (Point-in-Polygon) | B |

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

## ⭐ Star this repo if it helped you!

> *"The only way to learn programming is by programming."* — Dennis Ritchie
