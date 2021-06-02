package vn.udn.vku.tntan.appnhac.Service;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

import retrofit2.http.POST;
import vn.udn.vku.tntan.appnhac.Model.Album;
import vn.udn.vku.tntan.appnhac.Model.Baihat;
import vn.udn.vku.tntan.appnhac.Model.ChuDe;
import vn.udn.vku.tntan.appnhac.Model.Playlist;
import vn.udn.vku.tntan.appnhac.Model.Quangcao;
import vn.udn.vku.tntan.appnhac.Model.TheLoai;
import vn.udn.vku.tntan.appnhac.Model.TheloaiChude;

public interface Dataservice {
    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlistforcurrentday.php")
    Call<List<Playlist>> GetPlayListCurrentDay();

    @GET("chudevatheloaitrongngay.php")
    Call<TheloaiChude> GetChudeVaTheloaiCurrentDay();

    @GET("albumhot.php")
    Call<List<Album>> GetAlbumHot();

    @GET("baihatduocthich.php")
    Call<List<Baihat>> GetBaiHatHot();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihatquangcao(@Field("idquangcao") String idquangcao);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihatplaylist(@Field("idplaylist") String idplaylist);

    @GET("danhsachcacplaylist.php")
    Call<List<Playlist>> GetDanhsachcacplaylist();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheotheloai(@Field("idtheloai") String idtheloai);

    @GET("tatcachude.php")
    Call<List<ChuDe>> GetAllchude();

    @FormUrlEncoded
    @POST("theloaitheochude.php")
    Call<List<TheLoai>>GetTheloaitheochude(@Field("idchude") String idchude);

    @GET("tatcaalbum.php")
    Call<List<Album>> GetAllAlbum();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetdanhsachbaihattheoAlbum(@Field("idalbum")String idalbum);

    @FormUrlEncoded
    @POST("updateluotthich.php")
    Call<String> UpdateLike(@Field("luotthich") String luotthich, @Field("idbaihat") String idbaihat);

    @FormUrlEncoded
    @POST("searchbaihat.php")
    Call<List<Baihat>> GetSearch(@Field("tukhoa") String tukhoa);
}
