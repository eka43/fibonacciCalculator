import React from 'react';
import UserService from '../services/UserService';

class UserComponent extends React.Component {
	constructor(props) {
		super(props)
		this.state = {
			users:[],
			nValue:""
		}
		this.myChangeHandler = this.myChangeHandler.bind(this);
		this.saveUser = this.saveUser.bind(this);
	}

	saveUser = (event) => {
		event.preventDefault();
		let user = {nValue: this.state.nValue};
		//console.log('nvalue is => ' + JSON.stringify(user));
		//this.props.history.push('/users');

		UserService.createUser(user).then(res => {
			window.location.reload();
		});
	}
	
	componentDidMount(){
		UserService.getUsers().then((response) => {
			this.setState({ users: response.data})
		});
	}
	mySubmitHandler = (event) => {
		event.preventDefault();
		alert("You are submitting " + this.state.nValue);
	}
	myChangeHandler = (event) => {
		const re = /^[0-9\b]+$/;
		if (event.target.value === '' || re.test(event.target.value)) {
			this.setState({nValue: event.target.value});
		 }

	}
	
	render () {
		return (
			<div>
				<h1 className = "text-center">Fibonacci Calculator</h1>
				<form onSubmit={this.mySubmitHandler}>
				<p>Enter the n value to calculate Fibonacci: </p>
				<input
					type='text'
					name ="nValue"
					onChange={this.myChangeHandler}
					value={this.state.nValue}
				/>
				<input
				onClick={this.saveUser}
					type='submit'
				/>	
				<p></p>
				<table className = "table table-striped">
					<thead>
						<tr>
							<td> Trial Number</td>
							<td> N value</td>
							<td> Result</td>
							<td> Time</td>
						</tr>
					</thead>
					<tbody>
						{
							this.state.users.map(
							user =>
							<tr key= {user.id}>
								<td> {user.id}</td>
								<td> {user.nValue}</td>
								<td> {user.result}</td>
								<td> {user.time}</td>
							</tr>	
							)
						}
					</tbody>
				</table>
				</form>
			</div>
		)
	}
}

export default UserComponent