-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th5 01, 2021 lúc 11:09 AM
-- Phiên bản máy phục vụ: 10.3.16-MariaDB
-- Phiên bản PHP: 7.3.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `id16534196_mp3zing`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `album`
--

CREATE TABLE `album` (
  `IdAlbum` int(11) NOT NULL,
  `TenAlbum` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `TenCaSiAlbum` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `HinhAlbum` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `album`
--

INSERT INTO `album` (`IdAlbum`, `TenAlbum`, `TenCaSiAlbum`, `HinhAlbum`) VALUES
(1, 'THE ALBUM', 'BLACKPINK', 'https://tntan.000webhostapp.com/Hinhanh/Album/the_album_blackpink.jpg'),
(2, 'Xin Em(Album Collection 1)', 'Bùi Anh Tuấn', 'https://tntan.000webhostapp.com/Hinhanh/Album/xinemalb.jpg'),
(3, 'Em Không Sai Chúng Ta Sai (Single)', 'ERIK', 'https://tntan.000webhostapp.com/Hinhanh/Album/emkhongsaichungtasai.jpg'),
(4, 'Bạc Phận (Single)', 'Jack, K-ICM', 'https://tntan.000webhostapp.com/Hinhanh/Album/bac-phan.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baihat`
--

CREATE TABLE `baihat` (
  `IdBaiHat` int(11) NOT NULL,
  `IdAlbum` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `IdTheLoai` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `IdPlayList` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `TenBaiHat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `HinhBaiHat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Casi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `LinkBaiHat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `LuotThich` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `baihat`
--

INSERT INTO `baihat` (`IdBaiHat`, `IdAlbum`, `IdTheLoai`, `IdPlayList`, `TenBaiHat`, `HinhBaiHat`, `Casi`, `LinkBaiHat`, `LuotThich`) VALUES
(1, '1', '0', '0', 'How You Like That', 'https://tntan.000webhostapp.com/Hinhanh/Album/the_album_blackpink.jpg', 'BLACKPINK', 'https://imnew.000webhostapp.com/how_you_like_that.mp3', 8),
(2, '0', '1', '0', 'Kids In Love (Acoustic Version)', 'https://tntan.000webhostapp.com/Hinhanh/Baihat/KidsInLove.jpg', 'Kygo, The Night Game', 'https://imnew.000webhostapp.com/KidsInLove.mp3', 10),
(3, '0', '0', '1', 'Dancing With Your Ghost', 'https://tntan.000webhostapp.com/Hinhanh/Baihat/DancingWithYourGhost.jpg', 'Sasha Sloan', 'https://imnew.000webhostapp.com/DancingWithYourGhost.mp3', 6),
(4, '0', '0', '0', 'Chỉ Là Không Cùng Nhau ', 'https://tntan.000webhostapp.com/Hinhanh/Baihat/iconclkcn.jpg', 'Tăng Phúc, Trương Thảo Nhi', 'https://imnew.000webhostapp.com/chilakocungnhau.mp3', 7),
(5, '0', '0', '0', 'Lạc Trôi (Masew Trap Mix)', 'https://tntan.000webhostapp.com/Hinhanh/Baihat/lactoi.jpg', 'Sơn Tùng M-TP', 'https://imnew.000webhostapp.com/lactroi.mp3', 1),
(6, '0', '0', '2', 'Người Lạ Ơi', 'https://tntan.000webhostapp.com/Hinhanh/Baihat/nguoilaoi.jpg', 'Karik, Orange, Superbrothers', 'https://imnew.000webhostapp.com/nguoi-la-oi.mp3', 1),
(7, '0', '0', '3', 'Không Muốn Yêu Lại Càng Say Đắm', 'https://tntan.000webhostapp.com/Hinhanh/Baihat/KMYLCSD.jpg', 'Mr Siro', 'https://imnew.000webhostapp.com/mr-siro.mp3', 1),
(8, '0', '2', '0', 'Far And Beyond', 'https://tntan.000webhostapp.com/Hinhanh/Baihat/farandbeyond.jpg', 'Various Artists', 'https://imnew.000webhostapp.com/farandbeyond.mp3', 1),
(9, '0', '3', '0', 'Thanh Xuân', 'https://tntan.000webhostapp.com/Hinhanh/Baihat/thanhxuan-b.jpg', 'Da LAB', 'https://imnew.000webhostapp.com/thanhxuan.mp3', 9),
(10, '0\r\n', '4', '0', 'Cho Mình Em', 'https://tntan.000webhostapp.com/Hinhanh/Baihat/chominhem.jpg', 'Binz, Đen', 'https://imnew.000webhostapp.com/chominhem-dv.mp3', 1),
(11, '1', '0', '0', 'Ice Cream (With Selena Gomez)', 'https://tntan.000webhostapp.com/Hinhanh/Baihat/BLACKPINK-THE-ALBUM.jpg', 'BLACKPINK', 'https://imnew.000webhostapp.com/icecream.mp3', 1),
(12, '2', '0', '0', 'Xin Em', 'https://tntan.000webhostapp.com/Hinhanh/Baihat/xinemalb.jpg', 'Bùi Anh Tuấn', 'https://imnew.000webhostapp.com/XinEm-BuiAnhTuan-4586449.mp3', 1),
(13, '2', '0', '0', 'Bí Mật Không Tên', 'https://tntan.000webhostapp.com/Hinhanh/Baihat/xinemalb.jpg', 'Bùi Anh Tuấn', 'https://imnew.000webhostapp.com/bi-mat-ko-ten.mp3', 1),
(14, '3', '0', '0', 'Em Không Sai Chúng Ta Sai', 'https://tntan.000webhostapp.com/Hinhanh/Album/emkhongsaichungtasai.jpg', 'ERIK', 'https://imnew.000webhostapp.com/erick.mp3', 1),
(15, '4', '0', '0', 'Bạc Phận', 'https://tntan.000webhostapp.com/Hinhanh/Album/bac-phan.jpg', 'Jack, K-ICM', 'https://imnew.000webhostapp.com/bacphan.mp3', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chude`
--

CREATE TABLE `chude` (
  `IdChuDe` int(11) NOT NULL,
  `TenChuDe` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `HinhChuDe` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chude`
--

INSERT INTO `chude` (`IdChuDe`, `TenChuDe`, `HinhChuDe`) VALUES
(1, 'ACOUSTIC', 'https://tntan.000webhostapp.com/Hinhanh/Chude/acoustic.jpg'),
(2, 'Piano ', 'https://tntan.000webhostapp.com/Hinhanh/Chude/chude-piano.jpg'),
(3, 'Indie', 'https://tntan.000webhostapp.com/Hinhanh/Chude/indiechude.jpg\r\n'),
(4, 'Trending', 'https://tntan.000webhostapp.com/Hinhanh/Chude/trd.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `playlist`
--

CREATE TABLE `playlist` (
  `IdPlayList` int(11) NOT NULL,
  `Ten` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Hinhnen` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Hinhicon` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `playlist`
--

INSERT INTO `playlist` (`IdPlayList`, `Ten`, `Hinhnen`, `Hinhicon`) VALUES
(1, 'Top 100 Nhạc Pop Âu Mỹ Hay Nhất', 'https://tntan.000webhostapp.com/Hinhanh/Playlist/backroundtop100.jpg', 'https://tntan.000webhostapp.com/Hinhanh/Playlist/top100popaumy.jpg'),
(2, 'Top 100 Nhạc Rap Việt Nam Hay Nhất', 'https://tntan.000webhostapp.com/Hinhanh/Playlist/backroundtop100.jpg', 'https://tntan.000webhostapp.com/Hinhanh/Playlist/top100rapvieticon.jpg'),
(3, 'Top 100 Nhạc V-Pop Hay Nhất', 'https://tntan.000webhostapp.com/Hinhanh/Playlist/backroundtop100.jpg', 'https://tntan.000webhostapp.com/Hinhanh/Playlist/top100vpop-icon.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quangcao`
--

CREATE TABLE `quangcao` (
  `Id` int(11) NOT NULL,
  `Hinhanh` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Noidung` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Idbaihat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `quangcao`
--

INSERT INTO `quangcao` (`Id`, `Hinhanh`, `Noidung`, `Idbaihat`) VALUES
(1, 'https://tntan.000webhostapp.com/Hinhanh/Quangcao/quangcao-thealbum.jpg', 'The Album', 1),
(2, 'https://tntan.000webhostapp.com/Hinhanh/Quangcao/background-playlist.jpg', 'Mây In The Nest', 4),
(3, 'https://tntan.000webhostapp.com/Hinhanh/Quangcao/lactroi-quangcao.png', 'Tuyển tập những ca khúc hay nhất của Sơn Tùng M-TP', 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `theloai`
--

CREATE TABLE `theloai` (
  `IdTheLoai` int(11) NOT NULL,
  `IdChuDe` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `TenTheLoai` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `HinhTheLoai` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `theloai`
--

INSERT INTO `theloai` (`IdTheLoai`, `IdChuDe`, `TenTheLoai`, `HinhTheLoai`) VALUES
(1, '1', 'Acoustic EDM', 'https://tntan.000webhostapp.com/Hinhanh/Theloai/acoustic_edm.jpg'),
(2, '2', 'Peaceful Piano', 'https://tntan.000webhostapp.com/Hinhanh/Theloai/peaceful-piano.jpg'),
(3, '3', 'Indie Việt', 'https://tntan.000webhostapp.com/Hinhanh/Theloai/indie-viet.jpg'),
(4, '4', 'V-POP Đỉnh Cao Trending', 'https://tntan.000webhostapp.com/Hinhanh/Theloai/dinhcaotrending.jpg\r\n');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`IdAlbum`);

--
-- Chỉ mục cho bảng `baihat`
--
ALTER TABLE `baihat`
  ADD PRIMARY KEY (`IdBaiHat`);

--
-- Chỉ mục cho bảng `chude`
--
ALTER TABLE `chude`
  ADD PRIMARY KEY (`IdChuDe`);

--
-- Chỉ mục cho bảng `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`IdPlayList`);

--
-- Chỉ mục cho bảng `quangcao`
--
ALTER TABLE `quangcao`
  ADD PRIMARY KEY (`Id`);

--
-- Chỉ mục cho bảng `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`IdTheLoai`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `album`
--
ALTER TABLE `album`
  MODIFY `IdAlbum` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `baihat`
--
ALTER TABLE `baihat`
  MODIFY `IdBaiHat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `chude`
--
ALTER TABLE `chude`
  MODIFY `IdChuDe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `playlist`
--
ALTER TABLE `playlist`
  MODIFY `IdPlayList` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `quangcao`
--
ALTER TABLE `quangcao`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `theloai`
--
ALTER TABLE `theloai`
  MODIFY `IdTheLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
