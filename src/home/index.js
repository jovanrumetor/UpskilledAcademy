import './main.css'
import './bootstrap.min.css'
import matthewImage from '../asset/img/matthew-hamilton-tNCH0sKSZbA-unsplash.jpg'
import altaLogo from '../asset/img/logo-ALTA@2x.png'

function Home() {
  return (
        <div>
            <header>
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-8 col-md-12 col-sm-12 col-12">
                        <div class="alterra">
                            <a href="index.html"><img class="logo-atas" src={altaLogo}/></a>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12 col-sm-12 col-12">
                        <div class="container">
                            <div class="row align-items-center navig">
                                <div class="col-lg-3 col-md-3 col-sm-3 text-md-center text-sm-center text-lg-right"><a href="index.html" class="aktif">HOME</a></div>
                                <div class="col-lg-3 col-md-3 col-sm-3 text-md-center text-sm-center text-lg-center"><a href="about.html">ABOUT</a></div>
                                <div class="col-lg-3 col-md-3 col-sm-3 text-md-center text-sm-center text-lg-left"><a href="#">EXPERIENCE</a></div>
                                <div class="col-lg-3 col-md-3 col-sm-3 text-md-center text-sm-center text-lg-right"><a href="form.html">CONTACT</a></div> 
                            </div>
                    </div>
                    </div>    
                </div>
            </div> 
        </header>

        <div className="container h-100">
        <div className="row align-items-center isi-home">
        <div className="col-lg-4 col-md-12 col-sm-12  col-12">
            <img id="foto-profil" src={matthewImage} />
        </div>
        <div className="col-lg-8 col-md-12 col-sm-12 col-12">
            <div className="main-p">
            <p className="sapaan">Hi, my name is </p>
            <p className="nama">Anne Sullivan</p>
            <p className="hobi">I build things for the web</p>
            <p className="tombol"><a href="about.html">Get In Touch</a></p>
            </div>
        </div>
        </div>
    </div>
    </div>
    
  );
}
export default Home;
