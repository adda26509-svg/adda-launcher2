# Adda Launcher

An Android launcher for Minecraft: Java Edition — vanilla, Fabric, Forge,
NeoForge, and Quilt — built on Jetpack Compose with Material 3, targeting
Android 8+ with Java 21 support via a bundled JRE runtime.

Adda Launcher is a rebrand and fork of
[ZalithLauncher2](https://github.com/ZalithLauncher/ZalithLauncher2) by
MovTery. See [`NOTICE.md`](./NOTICE.md) for exactly what was changed and
what your obligations are under the GPL-3.0 license this project ships
under (see [`LICENSE`](./LICENSE)).

## Before you build

This fork is code-complete and renamed, but a few things need your own
values before it's really "yours" — the original author's identifiers
were deliberately left as empty placeholders rather than guessed:

1. **Signing keystore.** The original signing keys were removed (they
   were someone else's private key material). Generate your own:
   ```
   keytool -genkeypair -v -keystore AddaLauncher/adda_launcher.jks \
     -alias adda_launcher -keyalg RSA -keysize 2048 -validity 10000
   keytool -genkeypair -v -keystore AddaLauncher/adda_launcher_debug.jks \
     -alias adda_launcher_debug -keyalg RSA -keysize 2048 -validity 10000
   ```
   Then set `STORE_PASSWORD` / `KEY_PASSWORD` env vars, or
   `.store_password.txt` / `.key_password.txt` files in the repo root,
   matching what you used above.

2. **Update-check / community / support URLs.** In
   `AddaLauncher/src/main/java/com/adda/launcher/path/UrlManager.kt`,
   `URL_PROJECT`, `URL_PROJECT_INFO`, `URL_COMMUNITY`, `URL_WEBLATE`, and
   `URL_SUPPORT` are placeholders. `URL_PROJECT_INFO` in particular
   drives the in-app update checker — point it at your own release feed
   once you have one, or the update check will silently fail (which is
   safer than the alternative of it pointing at someone else's repo).

3. **Microsoft OAuth client ID.** Minecraft login needs an Azure AD app
   registration. Set `oauth_client_id` in
   `AddaLauncher/gradle.properties` (see the "Microsoft OAuth" section
   below).

4. **CurseForge API key**, if you want in-app mod search against
   CurseForge — set `curseforge_api_key` in the same file.

5. **App icon.** A simple original placeholder icon (red/black "A"
   monogram) is included so the app isn't wearing someone else's brand
   mark, but you'll probably want real design work here before shipping.

## Building

Requires Android Studio (Ladybird/Koala or newer) or a command-line
Gradle + Android SDK/NDK setup, since this project has native (JNI/C)
components alongside Kotlin.

```
./gradlew :AddaLauncher:assembleDebug
```

The debug build uses the default (insecure, checked-into-source)
passwords in `AddaLauncher/gradle.properties` unless you override them —
fine for local testing, **not** fine for anything you distribute.

On a resource-constrained build machine, note this project pulls in
LWJGL, a native JRE runtime, and multiple ABI-specific `.so` libraries —
expect a large first build and a large APK per-ABI.

## Setting up Microsoft OAuth

Minecraft account login uses the official Microsoft identity platform:

1. Register an app at the
   [Azure Portal](https://portal.azure.com) → App registrations.
2. Add a "Mobile and desktop applications" platform with a redirect URI
   matching this project's OAuth callback handling.
3. Copy the Application (client) ID into
   `AddaLauncher/gradle.properties` as `oauth_client_id`.
4. You are responsible for complying with Microsoft's identity platform
   terms of use for your own registered app.

## Module layout

- `AddaLauncher/` — the app itself (`com.adda.launcher`)
- `ColorPicker/` — in-house Compose color picker (`com.adda.colorpicker`)
- `LayerController/` — on-screen control layout editor
  (`com.adda.layer_controller`)
- `Terracotta/` — third-party LAN/VPN networking module (unchanged,
  separate license — see its own `LICENSE`/headers)
- `LWJGL/` — bundled LWJGL + Caciocavallo AWT bridge for running the
  Minecraft JVM's rendering and input on Android (unchanged, separate
  license)

## License

GPL-3.0. See `LICENSE` and `NOTICE.md`.
