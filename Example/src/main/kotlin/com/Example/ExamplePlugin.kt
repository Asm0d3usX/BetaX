package com.example
// 🏷 Package/namespace plugin, biasanya sesuai struktur project

import android.content.Context
// 📱 Context Android, dibutuhkan untuk akses resource, file, dll

import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
// ☁️ Annotation khusus CloudStream untuk menandai class ini sebagai plugin

import com.lagradost.cloudstream3.plugins.Plugin
// 🏗 Base class untuk semua plugin CloudStream

@CloudstreamPlugin
// 🟢 Menandai class ini sebagai plugin yang bisa di-load oleh CloudStream
class ExamplePlugin : Plugin() {
    // 🎯 Contoh class plugin utama, extend Plugin()

    override fun load(context: Context) {
        // 🚀 Fungsi utama saat plugin di-load oleh CloudStream
        registerMainAPI(Example())
        // 🧩 Mendaftarkan API utama plugin (Example() adalah class yang berisi logic)
    }
}
