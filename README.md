# Terminal 3D Game

A "3D" terminal-based game written in Java. Navigate through a 3D grid rendered in the terminal using ASCII characters.

---

## Features

- "3D" rendering using ASCII characters.
- Player movement (left, right, forward, backward).
- Dynamic screen updates.
- Sound effects.

---

## Requirements

- **Java Development Kit (JDK)**: Version 11 or later.
- **ALSA and PulseAudio**: May be required for sound playback on Linux.

---

## Installation

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/terminal_3d_game.git
cd terminal_3d_game
```
### 2. Install Dependencies

### On Linux:
You may have to install ALSA and PulseAudio for sound playback:

```bash
sudo apt-get update
sudo apt-get install alsa-utils pulseaudio
```

### On Mac:
No additional dependencies are required.

---

## Sound Playback

### On Linux
The game uses the Java Sound API (`javax.sound.sampled`) for sound playback. Ensure that ALSA and PulseAudio are installed and configured correctly if necessary.

### On Windows/Mac
Sound playback should work out of the box using the Java Sound API.

---

## Troubleshooting

### No Sound on Linux

1. Verify that ALSA and PulseAudio are installed:
```bash
sudo apt-get install alsa-utils pulseaudio
```

2. Test sound playback using aplay:
```bash
aplay resources/bell.wav
```

3. If aplay works but the Java Sound API doesn’t, ensure that your sound card is recognized:
```bash
aplay -l
```

4. If no sound cards are found, reconfigure ALSA:
```bash
sudo alsa force-reload
sudo dpkg-reconfigure alsa-base
```