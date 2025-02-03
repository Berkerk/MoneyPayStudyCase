Feature: Test

  Scenario: Migros sitesine git Kategorilerden Pet Shop seçilir
    Given Migros Sayfasına Git
    When Size En Yakın Migros Pop-up'ı kapat
    When Kategoriler sekmesini aç
    When Petshop linkine tıkla
    When Pethop Sayfasının açıldığını kontrol et
    When Sıralama Sayfasına tıkla ve Fiyatına göre En düşük seçeneğini seç
    When Fiyatların düşükten yükseğe doğru listelendiğini gör


