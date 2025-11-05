<?php
// URL embed dari FileDon
$url = "https://filedon.co/embed/6aPVU2JGo7";

// 1️⃣ Ambil halaman HTML
$html = file_get_contents($url);

// 2️⃣ Ambil token CSRF dari tag <meta name="csrf-token" content="...">
if (preg_match('/<meta name="csrf-token" content="([^"]+)"/', $html, $match)) {
    $token = $match[1];
} else {
    die("Gagal menemukan CSRF token!\n");
}

// 3️⃣ Ambil slug (bagian terakhir dari URL)
$slug = basename($url); // hasil: 6aPVU2JGo7

// 4️⃣ Siapkan data POST
$postData = http_build_query([
    '_token' => $token,
    'slug' => $slug
]);

// 5️⃣ Kirim POST request ke https://filedon.co/get-url
$ch = curl_init();
curl_setopt_array($ch, [
    CURLOPT_URL => "https://filedon.co/get-url",
    CURLOPT_POST => true,
    CURLOPT_POSTFIELDS => $postData,
    CURLOPT_RETURNTRANSFER => true,
    CURLOPT_HTTPHEADER => [
        "Content-Type: application/x-www-form-urlencoded",
        "Referer: $url",
        "User-Agent: Mozilla/5.0"
    ],
]);

$response = curl_exec($ch);
curl_close($ch);

// 6️⃣ Tampilkan hasil JSON response
header('Content-Type: application/json');
echo $response;
?>