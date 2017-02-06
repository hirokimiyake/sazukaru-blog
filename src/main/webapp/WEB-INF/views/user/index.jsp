<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container p-t-md">

<div class="row">
<!-- 左パネル -->
<div class="col-md-3">
<!-- プロフィール1 -->
<div class="panel panel-default panel-profile m-b-md">
<div class="panel-heading" style="background-image: url(assets/img/iceland.jpg);"></div>

<div class="panel-body text-center">
<a href="${pageContext.request.contextPath}/user/profile">
<img class="panel-profile-img" src="${pageContext.request.contextPath}${user.profile.displayPicturePath200x200}">
</a>

<h5 class="panel-title">
<a class="text-inherit" href="profile/index.html"><c:out value="${user.nickname}" /></a>
</h5>

<p class="m-b-md"><c:out value="${user.profile.introduction}" /></p>

<ul class="panel-menu">
<li class="panel-menu-item">
<a href="#userModal" class="text-inherit" data-toggle="modal">
お気に入り<h5 class="m-y-0">12M</h5>
</a>
</li>
</ul>

</div>
</div>
<!--// プロフィール1 -->

<!-- プロフィール2 -->
<div class="panel panel-default visible-md-block visible-lg-block">

<div class="panel-body">
<h5 class="m-t-0">プロフィール<c:if test="${user.myself==true}"> <small>· <a href="${pageContext.request.contextPath}/user/profile/edit">編集</a></small></c:if></h5>
<ul class="list-unstyled list-spaced">
<li><span class="text-muted icon icon-users m-r"></span>
<c:if test="${user.myself==false}"><c:if test="${user.profile.sexDiscloseKbn==true}"><c:out value="${user.profile.sex.kbnValueKanjiName}" /></c:if></c:if>
<c:if test="${user.myself==true}"><c:out value="${user.profile.sex.kbnValueKanjiName}" /></c:if>
</li>

<li><span class="text-muted icon icon-users m-r"></span>
<c:if test="${user.myself==false}"><c:if test="${user.profile.birthdayDiscloseKbn==true}"><c:out value="${user.profile.birthday}" /></c:if></c:if>
<c:if test="${user.myself==true}"><c:out value="${user.profile.birthday}" /></c:if>
</li>

<li><span class="text-muted icon icon-users m-r"></span>
<c:if test="${user.myself==false}"><c:if test="${user.profile.homePrefectureDiscloseKbn==true}"><c:out value="${user.profile.homePrefecture.kbnValueKanjiName}" /> </c:if></c:if>
<c:if test="${user.myself==true}"><c:out value="${user.profile.homePrefecture.kbnValueKanjiName}" /> </c:if>
</li>

<li><span class="text-muted icon icon-users m-r"></span>
<c:if test="${user.myself==false}"><c:if test="${user.profile.ninkatsuStyleDiscloseKbn==true}">
<c:forEach var="ninkatsuStyleKbn" items="${user.profile.ninkatsuStyle}"><c:out value="${ninkatsuStyleKbn.kbnValueKanjiName}" /> / </c:forEach>
</c:if></c:if>
<c:if test="${user.myself==true}">
<c:forEach var="ninkatsuStyleKbn" items="${user.profile.ninkatsuStyle}"><c:out value="${ninkatsuStyleKbn.kbnValueKanjiName}" /> / </c:forEach>
</c:if>
</li>

<li><span class="text-muted icon icon-users m-r"></span>
<c:if test="${user.myself==false}"><c:if test="${user.profile.troubleDiscloseKbn==true}">
<c:forEach var="troubleKbn" items="${user.profile.trouble}"><c:out value="${troubleKbn.kbnValueKanjiName}" /> / </c:forEach>
</c:if></c:if>
<c:if test="${user.myself==true}">
<c:forEach var="troubleKbn" items="${user.profile.trouble}"><c:out value="${troubleKbn.kbnValueKanjiName}" /> / </c:forEach>
</c:if>
</li>

<li><span class="text-muted icon icon-users m-r"></span>
<c:if test="${user.myself==false}"><c:if test="${user.profile.ryuzanDiscloseKbn==true}">
<c:forEach var="ryuzanKbn" items="${user.profile.ryuzan}"><c:out value="${ryuzanKbn.kbnValueKanjiName}" /> / </c:forEach>
</c:if></c:if>
<c:if test="${user.myself==true}">
<c:forEach var="ryuzanKbn" items="${user.profile.ryuzan}"><c:out value="${ryuzanKbn.kbnValueKanjiName}" /> / </c:forEach>
</c:if>
</li>

<li><span class="text-muted icon icon-users m-r"></span>
<c:if test="${user.myself==false}"><c:if test="${user.profile.husbandFuninDiscloseKbn==true}">
<c:forEach var="husbandFuninKbn" items="${user.profile.husbandFunin}"><c:out value="${husbandFuninKbn.kbnValueKanjiName}" /> / </c:forEach>
</c:if></c:if>
<c:if test="${user.myself==true}">
<c:forEach var="husbandFuninKbn" items="${user.profile.husbandFunin}"><c:out value="${husbandFuninKbn.kbnValueKanjiName}" /> / </c:forEach>
</c:if>
</li>

</ul>
</div>
</div>
<!--// プロフィール2 -->

</div>

    <div class="col-md-6">
      <ul class="list-group media-list media-list-stream">

        <li class="media list-group-item p-a">
          <div class="input-group">
            <input type="text" class="form-control" placeholder="Message">
            <div class="input-group-btn">
              <button type="button" class="btn btn-default">
                <span class="icon icon-camera"></span>
              </button>
            </div>
          </div>
        </li>

        <li class="media list-group-item p-a">
          <a class="media-left" href="#">
            <img
              class="media-object img-circle"
              src="assets/img/avatar-dhg.png">
          </a>
          <div class="media-body">
            <div class="media-heading">
              <small class="pull-right text-muted">4 min</small>
              <h5>Dave Gamache</h5>
            </div>

            <p>
              Aenean lacinia bibendum nulla sed consectetur. Vestibulum id ligula porta felis euismod semper. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
            </p>

            <div class="media-body-inline-grid" data-grid="images">
              <div style="display: none">
                <img data-action="zoom" data-width="1050" data-height="700" src="assets/img/unsplash_1.jpg">
              </div>

              <div style="display: none">
                <img data-action="zoom" data-width="640" data-height="640" src="assets/img/instagram_1.jpg">
              </div>

              <div style="display: none">
                <img data-action="zoom" data-width="640" data-height="640" src="assets/img/instagram_13.jpg">
              </div>

              <div style="display: none">
                <img data-action="zoom" data-width="1048" data-height="700" src="assets/img/unsplash_2.jpg">
              </div>
            </div>

            <ul class="media-list m-b">
              <li class="media">
                <a class="media-left" href="#">
                  <img
                    class="media-object img-circle"
                    src="assets/img/avatar-fat.jpg">
                </a>
                <div class="media-body">
                  <strong>Jacon Thornton: </strong>
                  Donec id elit non mi porta gravida at eget metus. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Donec ullamcorper nulla non metus auctor fringilla. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Sed posuere consectetur est at lobortis.
                </div>
              </li>
              <li class="media">
                <a class="media-left" href="#">
                  <img
                    class="media-object img-circle"
                    src="assets/img/avatar-mdo.png">
                </a>
                <div class="media-body">
                  <strong>Mark Otto: </strong>
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.
                </div>
              </li>
            </ul>
          </div>
        </li>

        <li class="media list-group-item p-a">
          <a class="media-left" href="#">
            <img
              class="media-object img-circle"
              src="assets/img/avatar-fat.jpg">
          </a>
          <div class="media-body">
            <div class="media-body-text">
              <div class="media-heading">
                <small class="pull-right text-muted">12 min</small>
                <h5>Jacob Thornton</h5>
              </div>
              <p>
                Donec id elit non mi porta gravida at eget metus. Integer posuere erat a ante venenatis dapibus posuere velit aliquet. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
              </p>
            </div>
          </div>
        </li>

        <li class="media list-group-item p-a">
          <a class="media-left" href="#">
            <img
              class="media-object img-circle"
              src="assets/img/avatar-mdo.png">
          </a>
          <div class="media-body">
            <div class="media-heading">
              <small class="pull-right text-muted">34 min</small>
              <h5>Mark Otto</h5>
            </div>

            <p>
              Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
            </p>

            <div class="media-body-inline-grid" data-grid="images">
              <img style="display: none" data-width="640" data-height="640" data-action="zoom" src="assets/img/instagram_3.jpg">
            </div>

            <ul class="media-list">
              <li class="media">
                <a class="media-left" href="#">
                  <img
                    class="media-object img-circle"
                    src="assets/img/avatar-dhg.png">
                </a>
                <div class="media-body">
                  <strong>Dave Gamache: </strong>
                  Donec id elit non mi porta gravida at eget metus. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Donec ullamcorper nulla non metus auctor fringilla. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Sed posuere consectetur est at lobortis.
                </div>
              </li>
            </ul>
          </div>
        </li>
      </ul>
    </div>
    <div class="col-md-3">
      <div class="alert alert-warning alert-dismissible hidden-xs" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <a class="alert-link" href="profile/index.html">Visit your profile!</a> Check your self, you aren't looking too good.
      </div>

      <div class="panel panel-default m-b-md hidden-xs">
        <div class="panel-body">
          <h5 class="m-t-0">Sponsored</h5>
          <div data-grid="images" data-target-height="150">
            <img class="media-object" data-width="640" data-height="640" data-action="zoom" src="assets/img/instagram_2.jpg">
          </div>
          <p><strong>It might be time to visit Iceland.</strong> Iceland is so chill, and everything looks cool here. Also, we heard the people are pretty nice. What are you waiting for?</p>
          <button class="btn btn-primary-outline btn-sm">Buy a ticket</button>
        </div>
      </div>

      <div class="panel panel-default m-b-md hidden-xs">
        <div class="panel-body">
        <h5 class="m-t-0">Likes <small>· <a href="#">View All</a></small></h5>
        <ul class="media-list media-list-stream">
          <li class="media m-b">
            <a class="media-left" href="#">
              <img
                class="media-object img-circle"
                src="assets/img/avatar-fat.jpg">
            </a>
            <div class="media-body">
              <strong>Jacob Thornton</strong> @fat
              <div class="media-body-actions">
                <button class="btn btn-primary-outline btn-sm">
                  <span class="icon icon-add-user"></span> Follow</button>
              </div>
            </div>
          </li>
           <li class="media">
            <a class="media-left" href="#">
              <img
                class="media-object img-circle"
                src="assets/img/avatar-mdo.png">
            </a>
            <div class="media-body">
              <strong>Mark Otto</strong> @mdo
              <div class="media-body-actions">
                <button class="btn btn-primary-outline btn-sm">
                  <span class="icon icon-add-user"></span> Follow</button></button>
              </div>
            </div>
          </li>
        </ul>
        </div>
        <div class="panel-footer">
          Dave really likes these nerds, no one knows why though.
        </div>
      </div>

      <div class="panel panel-default panel-link-list">
        <div class="panel-body">
          © 2015 Bootstrap

          <a href="#">About</a>
          <a href="#">Help</a>
          <a href="#">Terms</a>
          <a href="#">Privacy</a>
          <a href="#">Cookies</a>
          <a href="#">Ads </a>

          <a href="#">info</a>
          <a href="#">Brand</a>
          <a href="#">Blog</a>
          <a href="#">Status</a>
          <a href="#">Apps</a>
          <a href="#">Jobs</a>
          <a href="#">Advertise</a>
        </div>
      </div>
    </div>
  </div>
</div>