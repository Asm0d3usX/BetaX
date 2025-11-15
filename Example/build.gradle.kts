version = 1
// 🏷 Versi plugin, bisa diupdate jika ada perubahan besar

cloudstream {
    description = "Example cloudstream plugin"
    // 📝 Deskripsi singkat tentang plugin, bisa muncul di UI CloudStream

    language = "id"
    // 🗣 Bahasa plugin, "id" = Indonesia. Bisa juga "en", "jp", dll.

    authors = listOf("Example")
    // 👤 Daftar penulis/pembuat plugin, bisa lebih dari satu

    status = 1
    // ⚡ Status plugin:
    // 1 = aktif / stabil
    // 0 = development / testing

    isCrossPlatform = true
    // 🌐 Menunjukkan plugin bisa dijalankan di Android dan TV / perangkat lain

    tvTypes = listOf(
        "Movie",
        "TvSeries",
        "AsianDrama",
    )
    // 🎬 Tipe konten yang didukung plugin
    // Bisa muncul di filter atau kategori di CloudStream
}
