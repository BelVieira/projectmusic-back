import React from 'react';
import logo from './logo.svg';
import './App.css';

export default class App extends React.Component{

  state = {
    name: "",
    artist: "",
    duration: "",
    returnDataMusics: ""
  }

  inserir = () => {
    console.log(this.state);
  }

  insert = () =>{
    const returnDataMusics = "Nome: " + this.state.name + " Artista: " +
    this.state.artist + " Duração: " + this.state.duration;
    this.setState({returnDataMusics})
  }

  render(){
    return (
      <div ClassName= "App">
        <label> Dados das músicas </label>
        <br/>
          <label> Nome: </label>
            <input type = "text" value={this.state.name} onChange = {(e) => {this.setState({name: e.target.value})}} />
            
            <br/>
            <label> Artista: </label>
            <input type = "text" value={this.state.artist} onChange = {(e) => {this.setState({artist: e.target.value})}} />
        
            <br/>
            <label> Duração: </label>
            <input type = "text" value={this.state.duration} onChange = {(e) => {this.setState({duration: e.target.value})}} />
            
            <br/>
            <button onClick = {this.insert}>Inserir</button>
            
            <br/>
            <label>Os dados das musicas são: {this.state.returnDataMusics}</label>
           <br/>
           
         
      </div>
      )
    }   
  }