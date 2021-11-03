<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar">
    <a class="navbar-brand" href="./">
        <span class="logo-element">
            <span class="logo-tape">
                <span class="svg-content svg-fill-theme" data-svg="./images/svg/logo-part.svg"></span>
            </span>
            <span class="logo-text text-uppercase">
                <span>L</span>ittle Cinema</span>
        </span>
    </a>
    <button class="navbar-toggler" type="button">
        <span class="th-dots-active-close th-dots th-bars">
            <span></span>
            <span></span>
            <span></span>
        </span>
    </button>
    <div class="navbar-collapse">
        <ul class="navbar-nav">
            <li class="nav-item nav-item-arrow-down nav-hover-show-sub">
                <a class="nav-link" href="#">영화관 소개</a>
                <div class="nav-arrow"><i class="fas fa-chevron-down"></i></div>
                <ul class="collapse nav">
                    <li class="nav-item">
                        <a class="nav-link" href="homepage-1.html">1관</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="homepage-2.html">2관</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="homepage-2.html">3관</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="homepage-3.html">좌석배치도</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="homepage-3.html">오시는 길</a>
                    </li>
                </ul>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="timetable">상영시간표</a>
            </li>
            <li class="nav-item nav-item-arrow-down nav-hover-show-sub">
                <a class="nav-link" href="#">영화정보</a>
                <div class="nav-arrow"><i class="fas fa-chevron-down"></i></div>
                <ul class="collapse nav">
                    <li class="nav-item">
                        <a class="nav-link" href="homepage-1.html">현재 상영작</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="scheduled-movies">상영 예정작</a>
                    </li>
                </ul>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="movies-blocks.html">고객센터</a>
            </li>
        </ul>
        <div class="navbar-extra">
	        <a href="login-signup">
			    <button type="button" class="btn btn-outline-theme">
			        <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
			            <path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z">
			            </path>
			            <path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z">
			            </path>
			        </svg>
			        로그인
			    </button>
	        </a>
            <a class="btn-theme btn" href="booking"><i class="fas fa-ticket-alt"></i>&nbsp;&nbsp;예매하기</a>
        </div>
    </div>
</nav>