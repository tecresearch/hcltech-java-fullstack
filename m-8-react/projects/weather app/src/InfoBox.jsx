import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import ThunderstormIcon from '@mui/icons-material/Thunderstorm';
import AcUnitIcon from '@mui/icons-material/AcUnit';
import WbSunnyIcon from '@mui/icons-material/WbSunny';

import "./InfoBox.css";


export default function InfoBox({info}){

    const coldWheather = "https://images.pexels.com/photos/28518049/pexels-photo-28518049/free-photo-of-winter-wonderland-by-a-frozen-river.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1";
    const hotWeather = "https://media.istockphoto.com/id/1150050227/photo/heat-wave-of-extreme-sun-and-sky-background-hot-weather-with-global-warming-concept.jpg?s=612x612&w=0&k=20&c=EjBSIEDX39FRrARa7xiZyJtoXdgl3mePScIEQq9iW1U=";
    const rainWeather = "https://images.pexels.com/photos/28666233/pexels-photo-28666233/free-photo-of-serene-forest-pathway-during-a-misty-day.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1";

    return (
     <div className="infoBox">
        <h2>{info.city} Wheather Today</h2>
        <div className='cardContainer'>
        <Card sx={{ maxWidth: 345 }}>
      <CardMedia
        sx={{ height: 140 }}
        image={info.humidity > 80 ? rainWeather : info.temp > 15 ? hotWeather : coldWheather}
        title="Wheather"
      />
      <CardContent>
        <Typography gutterBottom variant="h5" component="div">
        <h4>{info.weather} {info.humidity > 80 ? <ThunderstormIcon/> : info.temp > 15 ? < WbSunnyIcon/> : <AcUnitIcon/>}</h4>
        </Typography>
        <Typography variant="body2" sx={{ color: 'text.secondary'}} component={"span"}>
          <p>Temperature = {info.temp}&deg;C</p>
          <p>Humidity = {info.humidity}</p>
          <p>Min Temp = {info.tempMin}&deg;C</p>
          <p>Max Temp = {info.tempMax}&deg;C</p>
          <p>Feels Like = {info.feelsLike}&deg;C</p>
        </Typography>
      </CardContent>
      </Card>
      </div>  
    </div>
    )
}