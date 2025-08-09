Rent A Car Web API
Proje Açıklaması

Bu proje, araç kiralama operasyonlarını yönetmek için geliştirilmiş bir RESTful Web API uygulamasıdır.
Java 24 ve Spring Boot kullanılarak geliştirilmiştir.
Müşteri yönetimi, araç yönetimi, rezervasyon işlemleri gibi temel CRUD işlemleri sağlar.
Özellikler

    Katmanlı mimari (Controller, Service, Repository)

    DTO ve Mapper kullanımı

    Veri doğrulama (Validation)

    Exception Handling

    Yetkiye göre veri gösterimi (Admin / Resepsiyonist)

Kullanılan Teknolojiler

    Java 24

    Spring Boot

    Spring Data JPA

    Hibernate

    Lombok

    H2 Database (veya başka DB yapılandırılabilir)

    Maven

Kurulum ve Çalıştırma

    Repoyu klonlayın:

git clone https://github.com/hakancemG/Rent-A-Car-Web-API.git

    Proje dizinine gidin:

cd Rent-A-Car-Web-API

    Maven ile bağımlılıkları yükleyin:

mvn clean install

    Uygulamayı çalıştırın:

mvn spring-boot:run

    API varsayılan olarak şu adreste çalışır:

http://localhost:8080

API Örnek Endpoint’ler
HTTP Metodu	Endpoint	Açıklama
GET	/admin/customers/{id}	Belirli müşteriyi getirir
POST	/customers	Yeni müşteri oluşturur
DELETE	/customers/{id}	Müşteri siler
Notlar

    Java versiyonu: 24

    Varsayılan veritabanı: H2 (application.properties üzerinden değiştirilebilir)

    DTO ve Mapper yapısı ile veri transferinde güvenlik ve esneklik sağlanmıştır.
