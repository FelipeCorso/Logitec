// JavaScript Document

$(function(){
	$('#conteudo').hide();
	var noticia;	
	var hash = window.location.hash;
	if (hash !='')
	{
		noticia = $(hash).html();
		$('.nav li a[href="' + hash + '"]').parent().addClass('active');		
	} else {
		noticia = $('#conteudo div:first-child').html();			
		$('.nav li:first-child').addClass('active');		
	}
	$('#noticia').append('<div>' + noticia + '</div>').find('div').slideDown();
	$('.nav li a').click(function(){
		$('.nav li').removeClass('active');
		$(this).parent().addClass('active');
		var ancora = $(this).attr('href');
		var nome = ancora.substr(1, ancora.length);
		noticia = $('#conteudo div[id="' + nome + '"]').html();
		$('#noticia').empty();
		$('#noticia').append('<div>' + noticia + '</div>').find('div').slideDown();
	return false();
	})
})