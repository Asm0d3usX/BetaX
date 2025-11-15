package com.example

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.LoadResponse.Companion.addActors
import com.lagradost.cloudstream3.LoadResponse.Companion.addScore
import com.lagradost.cloudstream3.LoadResponse.Companion.addTrailer
import com.lagradost.cloudstream3.utils.*
import org.jsoup.nodes.Element
import java.net.URI

class Example : MainAPI() {
    // 🌐 Plugin utama untuk CloudStream, extend MainAPI
    override var mainUrl = "https://Example.com"  // URL dasar situs
    override var name = "Example"                // Nama plugin
    override val hasMainPage = true              // Menunjukkan ada main page
    override var lang = "id"                     // Bahasa plugin
    override val supportedTypes = setOf(
        TvType.Movie, TvType.TvSeries, TvType.Anime, TvType.AsianDrama
    ) // 📌 Tipe konten yang didukung

    private var directUrl: String? = null // 🗝 Menyimpan URL dasar saat load detail

    // 🏠 Main page categories
    override val mainPage = mainPageOf(
        "example1/page/%d/" to "Example 1",
        "example2/page/%d/" to "Example 2",
        "example3/page/%d/" to "Example 3"
    )

    // 📄 Ambil list movie di main page
    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse { ... }

    // 🔍 Konversi HTML element ke SearchResponse (Movie/TV/Anime)
    private fun Element.toSearchResult(): SearchResponse? { ... }

    // 🔎 Fungsi search plugin
    override suspend fun search(query: String): List<SearchResponse> { ... }

    // 🔗 Konversi element rekomendasi ke SearchResponse
    private fun Element.toRecommendResult(): SearchResponse? { ... }

    // 🎬 Ambil detail movie/TV + episode + metadata
    override suspend fun load(url: String): LoadResponse { ... }

    // 📺 Load semua link/streaming/extractor dari halaman
    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean { ... }

    // 🖼 Ambil atribut image dari HTML element
    private fun Element.getImageAttr(): String = ...

    // 🏗 Ambil URL iframe dari element
    private fun Element?.getIframeAttr(): String? = ...

    // 🔧 Perbaiki URL poster agar kualitas penuh
    private fun String?.fixImageQuality(): String? = ...

    // 🏠 Ambil base URL dari URL lengkap
    private fun getBaseUrl(url: String): String = ...
}
