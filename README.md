# Sistem Booking Hotel Online : Valora

Sistem ini adalah sistem rekayasa yang dibuat untuk memenuhi tugas mata kuliah Sistem Terdistribusi

**Prasyarat :**

1. JDK 8
2. Gradle 6.5
3. Docker

**Cara menggunakan :**

Eksekusi command berikut di folder root (folder yang ada file `docker-compose.yml` nya)
```
gradle build
docker-compose build
docker-compose up
```

**Daftar port :**

* Host dan Port untuk Valora Service, http://localhost:9001/
* Host dan Port untuk Blue Door Hotel Service, http://localhost:9002/
* Host dan Port untuk Grey Door Hotel Service, http://localhost:9003/

**Daftar Endpoint :**

Daftar Endpoint untuk Hotel Service
Method | URI | Deskkripsi | Parameter | Request JSON | Response JSON
--- | --- | --- | --- | --- | ---
`GET` | */rooms/list* | Daftar semua kamar (rooms) | None | None |
`GET` | */rooms/list/status/{status}* | Daftar semua kamar (rooms) dengan status tertentu | None | None |
`GET` | */rooms/list/type/{type}* | Daftar semua kamar (rooms) dengan type tertentu | None | None |
`GET` | */rooms/id/{id}* | Sebuah kamar (room) dengan ID tertentu | None | None |
`POST` | */rooms* | Menambahkan sebuah kamar baru | None | class `Room` |
`PUT` | */rooms* | Mengubah detil sebuah kamar | None | class `Room` |
`DELETE` | */rooms/id/{id}* | Menghapus sebuah kamar dengan ID tertentu | None | None |

Daftar Endpoint untuk Valora Service
Method | URI | Deskkripsi | Parameter | Request JSON | Response JSON
--- | --- | --- | --- | --- | ---
`GET` | */rooms/list* | Daftar semua kamar (rooms) | None | None |
`POST` | */rooms/book* | Melakukan transaksi sewa kamar | None | class `Transaction`  |
`POST` | */rooms/unbook* | Melakukan transaksi batalkan sewa kamar | None | class `Transaction` |

## Kelompok : 7
### Anggota :
1. Annazar Darul Ismawan
2. Melina Nurliana Pratiwi
3. Zahran Haykal Mubarok

**Jurusan Teknik Komputer dan Informatika**

**Prodi D4 - Teknik Informatika**

**Politeknik Negeri Bandung**

**2017**
