# Adda Launcher

An Android launcher for **Minecraft: Java Edition** — play vanilla, Fabric, Forge, NeoForge, and Quilt right on your phone or tablet.

Built with Jetpack Compose and Material 3, targeting Android 8+, with a bundled Java 21 runtime so you don't need to install anything else to play.

---

## ✨ Features

- 🎮 **Multiple mod loaders** — Vanilla, Fabric, Forge, NeoForge, Quilt
- 👤 **Account manager** — Microsoft account login + offline accounts, switch between multiple profiles
- 📦 **Version manager** — install, delete, and repair game versions with corruption detection
- 🧩 **Mods, resource packs & shaders** — browse, enable/disable, import, and manage everything from one place
- 🌍 **Worlds manager** — backup, restore, rename, export your saves
- 📸 **Screenshot gallery** — view, share, and manage your captures
- ☁️ **Cloud backup** — OneDrive sync for worlds and screenshots
- ⚙️ **Deep settings** — Java path, RAM allocation, renderer options, resolution, controls, language, theme
- 🎨 **Theme engine** — Light, Dark, AMOLED black, and custom accent colors
- 🚀 **Built for low-end devices** — tuned to run smoothly on 3GB–4GB RAM phones, with smart RAM allocation recommendations
- 🌐 **Multi-language** — English, Hindi, Urdu (more coming)

## 📱 Requirements

- Android 8.0 (Oreo) or newer
- ARM64 device recommended (armeabi-v7a also supported)
- 3GB+ RAM (4GB+ recommended for modded play)

## 📥 Download

> Pre-built APKs will be published under [Releases](../../releases) once a stable build is ready.

For now, see [Building from source](#-building-from-source) below.

## 🛠️ Building from source

Requires Android Studio (or command-line Gradle + Android SDK/NDK, since this project has native components).

```bash
git clone https://github.com/adda26509-svg/adda-launcher2.git
cd adda-launcher2
./gradlew :AddaLauncher:assembleDebug
