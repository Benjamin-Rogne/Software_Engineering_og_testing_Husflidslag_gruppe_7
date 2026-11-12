import { Link, useNavigate } from "react-router";
import { User, LogOut } from "lucide-react";
import { loggUt } from "../api/bruker.js";

// Toppfelt over hele siden.
// Ikke innlogget: knapp for å logge inn. Innlogget: navn og knapp for å logge ut.
export default function Toppfelt({ bruker, setBruker }) {
  const navigate = useNavigate();


  // logger ut i backend og nullstiller
  async function handleLoggUt() {
    await loggUt();
    setBruker(null);
    navigate("/");
  }

  return (
    <header className="toppfelt">
      {bruker ? (
        <p className="toppfelt-bruker">
          <User aria-hidden="true" />
          Hei, {bruker.navn}
          {/* brukt button da det er en handling og ikke side bytte */}
          <button type="button" className="logg-ut" onClick={handleLoggUt}>
            <LogOut aria-hidden="true" />
            Logg ut
          </button>
        </p>
      ) : (
        <Link to="/logg-inn" className="logg-inn">
          <User aria-hidden="true" />
          Logg inn
        </Link>
      )}
    </header>
  );
}