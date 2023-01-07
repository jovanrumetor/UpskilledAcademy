import { useState, useEffect } from "react";
import { Navbar } from "../../components/navbar/navbar";
import './register.css';
import { useForm } from "react-hook-form";

const Register = () => {
    const {
      register,
      handleSubmit,
      reset,
      formState: { errors },
    } = useForm();
  
  const onSubmit = (data, e) => alert(`Data Pendaftar ${data.fullname} Berhasil Diterima`);
  const onError = (errors, e) => alert("Data Pendaftar Tidak Sesuai");

    
  // const handleClick = async e => {
  //   e.preventDefault();
  //   try {
  //     if (todo.length == 0) {
  //       alert("Input Todo Tidak Boleh Kosong")
  //       return false
  //     }
  //     const newTodos = [...todos, {id: todos.length +1, title: todo, completed: false} ]
  //     setTodos(newTodos)
  //     setTodo('')
  //   } catch (err) {
  //   }
  // }

  return (
    <div>
    <Navbar/>
    <div className="container">
    <h1>Pendaftaran Peserta Coding Bootcamp</h1>
    <form onSubmit={handleSubmit(onSubmit, onError)}>
      <div className='formInputRegister'>
        <label>
        Nama Lengkap:
        <input className="inputText" {...register('fullname', 
        { required: true,  pattern: /[A-Za-z]{3}/
        })} />
        </label>    
        <label>
        Email:
        <input className="inputText" {...register('email', { required: true })} />
        </label>  
        <label>
        No Handphone:
        <input className="inputText" type="number" {...register('phoneNumber', { required: true, minLength: 9, maxLength: 14 })} />
        </label>  
        <div className="radioBtn">
        Latar Belakang Pendidikan
        </div>
        <div className="radioField">
                <label htmlFor="IT">
                    <input
                        {...register("bgEducation", { required: true })}
                        type="radio"
                        value="true"
                        id="IT"
                        name="bgEducation"
                    />
                    IT
                </label>
                <label htmlFor="nonIT">
                    <input
                        {...register("bgEducation", { required: true })}
                        type="radio"
                        value="false"
                        id="nonIT"
                        name="bgEducation"
                    />
                    Non IT
                </label>  
        </div>
        <label>
       Kelas Koding yang Dipilih:
        <select className="inputText" {...register("codingClass", { required: true })}>
          <option value="">Pilih Salah Satu Program</option>
          <option value="Coding Backend with Golang">Coding Backend with Golang</option>
          <option value="Coding Frontend With ReactJS">Coding Frontend With ReactJS</option>
          <option value="Fullstack Developer">Fullstack Developer</option>
        </select>
        </label>
        <label>
          Foto Surat Kesungguhan:
          <input className="inputFile" type="file" {...register('commitmentPaper', { required: true })} />
        </label>
        <label>
          Harapan Untuk Coding Bootcamp ini:
          <textarea className="inputArea"  {...register('expectation')}></textarea>
        </label>
        <div className="errorMsg">
        {errors.fullname && <p>Nama Lengkap Harus Berupa Huruf</p>}
        {errors.email && <p>Email Tidak Sesuai</p>}
        {errors.phoneNumber && <p>No Handphone Tidak Sesuai</p>}
        {errors.bgEducation && <p>Latar Belakang Pendidikan Harus Dipilih</p>}
        {errors.codingClass && <p>Kelas Koding Harus Dipilih</p>}
        {errors.commitmentPaper && <p>Surat Kesungguhan Harus Dimasukkan</p>}
        </div>
      </div>
      <div className="btnGroup">
        <button type="submit" className="btnSubmit">Submit</button>
        <button className="btnReset" type="reset">Reset</button>
      </div>
     
    </form>
    </div>
  </div>
  )
}

export default Register