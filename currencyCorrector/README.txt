# Live Currency Converter

A lightweight, zero-dependency Java command-line application that pulls live foreign exchange rates from the European Central Bank via the Frankfurter public API ecosystem.

## Core Concepts Implemented
- **Networking APIs**: Working directly with `URL` and `HttpURLConnection`.
- **Stream Implementations**: Reading inbound network text buffers with `BufferedReader`.
- **Native String Slicing**: Manually extracting values from dynamic payload responses without needing heavy JSON frameworks.
- **Exception Scoping**: Graceful fallbacks for unknown currency abbreviations or hardware connection time-outs.