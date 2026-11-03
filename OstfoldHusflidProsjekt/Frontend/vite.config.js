import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      // /api/* sendes videre til Java-backenden på port 7000
      "/api": "http://localhost:7000",
    },
  },
});