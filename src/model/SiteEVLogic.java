package model;

public class SiteEVLogic {
	//「いいね」の数の計算
	public void like(SiteEV site) {
		int count = site.getLike();
		site.setLike(count + 1);
	}
	//「よくないね」の数の計算
	public void dislike(SiteEV site) {
		int count = site.getDislike();
		site.setDislike(count + 1);
	}
}
