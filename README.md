# CPU Scheduling Simulation (Java)

## Proje Amacı

Bu proje, İşletim Sistemleri dersinde anlatılan CPU Scheduling algoritmalarını simüle etmek amacıyla hazırlanmıştır.

Projede öğrencilerden, verilen iskelet yapı üzerinde aşağıdaki algoritmaları kendilerinin implemente etmesi beklenmektedir:

- FCFS (First Come First Served)
- SJF (Shortest Job First)
- Priority Scheduling
- Round Robin (RR)
- Priority Round Robin (PriorityRR)

---

## Genel Çalışma Mantığı

Program şu şekilde çalışır:

schedule.txt → Task listesi → Scheduler seçimi → schedule() → CPU.run()

1. Kullanıcı algoritma seçer  
2. schedule.txt dosyasından görevler okunur  
3. Görevler bir List<Task> içine alınır  
4. Seçilen scheduler sınıfı oluşturulur  
5. schedule() metodu çalıştırılır  
6. Görevler CPU’da çalıştırılıyormuş gibi simüle edilir  

---

## Proje Yapısı

```
scheduler-simulation/
├── pom.xml
├── schedule.txt
├── src/
│   └── com/mycompany/schedulersim/
│       ├── Algorithm.java
│       ├── CPU.java
│       ├── Task.java
│       ├── Schedulersim.java
│       ├── FCFS.java
│       ├── SJF.java
│       ├── Priority.java
│       ├── RR.java
│       └── PriorityRR.java
```
---

## Dosyaların Açıklaması

### Schedulersim.java

Programın ana sınıfıdır (main class).

Görevleri:
- Kullanıcıdan algoritma seçimini almak  
- schedule.txt dosyasını okumak  
- Task listesi oluşturmak  
- İlgili scheduler sınıfını başlatmak  
- schedule() metodunu çağırmak  

---

### Task.java

Bir görevi (process) temsil eder.

İçerdiği bilgiler:
- name → görev adı  
- tid → benzersiz ID  
- priority → öncelik değeri  
- burst → CPU süresi  

---

### Algorithm.java

Tüm scheduler sınıflarının uyması gereken interface.

```java
void schedule();
Task pickNextTask();
```

- schedule() → algoritmanın ana akışı
- pickNextTask() → sıradaki görevi seçer

---

### CPU.java

CPU çalışmasını simüle eder.

```java
CPU.run(task, slice);
```

-	slice → CPU’da çalıştırılan süre (özellikle RR için önemli)
- Gerçek işlem yapılmaz, sadece çıktı üretir

---

### schedule.txt

Programın input dosyasıdır.

Format:

T1, 4, 20<br>
T2, 3, 25<br>
T3, 1, 15

Anlamı:

isim, priority, burst


---

### Scheduler Sınıfları

Bu sınıflar bilerek eksik bırakılmıştır.
Öğrencilerin bu sınıfları tamamlaması beklenir.


FCFS.java
	•	İlk gelen ilk çalışır
	•	Queue sırası bozulmaz



SJF.java
	•	En kısa burst süresi seçilir
	•	Her adımda yeniden seçim yapılır



Priority.java
	•	En yüksek priority değeri seçilir
	•	Eşitlik durumunda FCFS uygulanabilir



RR.java
	•	Round Robin algoritması uygulanır
	•	Her görev quantum kadar çalıştırılır
	•	Bitmeyen görev kuyruğun sonuna eklenir



PriorityRR.java
	•	Önce en yüksek priority grubu seçilir
	•	Aynı priority içindeki görevlerde Round Robin uygulanır

---

Projeyi Çalıştırma

1. Repo’yu klonla
```bash
git clone https://github.com/semihozenc/scheduler-simulation.git
```

---

2. NetBeans (veya başka bir editör) ile aç

File → Open Project → scheduler-simulation


---

3. Programı çalıştır

Main class:

Schedulersim.java


---

4. Algoritma seç

1 - FCFS<br>
2 - SJF<br>
3 - Priority<br>
4 - RR<br>
5 - PriorityRR


---

5. Dosya adı gir

schedule.txt


---

Öğrencilerden Beklenenler
-	Scheduler sınıflarını implemente etmek
-	schedule() metodunu doğru yazmak
-	pickNextTask() metodunu tamamlamak
-	RR için quantum mantığını kurmak
-	PriorityRR algoritmasını doğru uygulamak
-	Farklı algoritmaların çıktısını karşılaştırmak

---

Dikkat Edilmesi Gerekenler
- RR algoritmasında:
  - Burst değeri azaltılmalıdır  
  - Task tekrar kuyruğa eklenmelidir  
- CPU çıktısında:
  - Toplam burst değil, çalıştırılan slice yazdırılmalıdır
- Eşit priority/burst durumunda:
  - FCFS uygulanabilir
  - Infinite loop oluşmamasına dikkat edilmelidir

---

Önemli Not:

  Bu proje tam çalışan bir çözüm içermez.

Amaç:

  Öğrencinin scheduler algoritmalarını kendisinin geliştirmesidir.

---
