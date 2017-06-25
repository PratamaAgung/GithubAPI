# GithubAPI
Java project using GitHub API

Dalam pengembangan aplikasi berbasis Java ini, digunakan beberapa elemen dasar, yakni JSON file, REST, dan GitHub API.

## Dependencies
Project ini menggunakan extrenal library, yaitu org.json dan Swing
* org.json digunakan untuk mengelola struktur data json. Library yang digunakan adalah org,json versi 20140107.
* Swing digunakan untuk menampilkan GUI pada aplikasi ini. Library yang digunakan adalah Swing default pada IntelliJ IDEA 2017.

## Struktur File JSON
JSON merupakan singkatan dari JavaScript Object Notation, adalah suatu struktur penyimpanan data yang terorganisir dengan baik dan mudah diakses. Struktur data ini cukup banyak digunakan dalam pengembangan aplikasi, dan banyak tersedia library untuk akses data dari struktur file tersebut, misalnya pada bahasa pemrograman java, terdapat library org.json.
Salah satu contoh struktur data JSON adalah seperti berikut
```
var agung = {
  "age" : 19,
  "address" : "cilacap"
};
```
Struktur tersebut mendefinisikan objek "agung"  yang mempunyai umur 19 dan tinggal di cilacap.

## RESTful Web Service
REST (Representational State Transfer) merupakan suatu struktur arsitektur pengembangan perangkat lunak berbasis web sehingga aplikasi tersebut dapat bekerja dengan "ringan", dapat di-maintain dengan baik, serta dapat dikembangkan lebih lanjut. Arsitektur ini mencoba mengelola resource sehingga user dapat mnegakses resource tersebut dengan baik dan "murah" (tidak terlalu banyak cost). Pada umumnya, RESTful web service mempunyai beberapa fitur sebagai berikut:
* Representations
* Messages
* URIs
* Uniform interface
* Stateless
* Links between resource
* Caching

## GitHub API
API atau Application Program Interface merupakan protokol dan alat untuk mengembangkan aplikasi. API memperlihatkan bagaimana komponen dari suatu software berinteraksi.
GitHub API merupakan suatu API yang disediakan oleh GitHub. Menggunakan API ini, developer dapat mengakses data-data yang ada pada GitHub. Sebagai contoh, pada project kali ini, API yang ada akan digunakan untuk mengakses data user GitHub dan project-project yang pernah dikembangkannya.
